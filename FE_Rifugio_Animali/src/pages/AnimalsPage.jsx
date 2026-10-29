import { useEffect, useState } from "react";
import { apiPage } from "../api";
import Alert from "../components/Alert";
import { SelectInput, TextInput } from "../components/FormControls";
import Loading from "../components/Loading";
import { genderOptions, speciesOptions } from "../constants";
import { Link } from "../router";
import { ageFromBirthDate, pageContent, valueOrDash } from "../utils/formatters";

const emptyFilters = {
  nome: "",
  sesso: "",
  specie: "",
  razza: "",
  pesoMax: "",
  etaMax: ""
};

export default function AnimalsPage({ availableOnly = false }) {
  const [filters, setFilters] = useState(emptyFilters);
  const [appliedFilters, setAppliedFilters] = useState(emptyFilters);
  const [rows, setRows] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    let cancelled = false;
    apiPage("/animals", {
      ...appliedFilters,
      disponibileAdozione: availableOnly ? true : undefined,
      size: 200
    })
      .then((page) => {
        if (!cancelled) setRows(pageContent(page));
      })
      .catch((err) => {
        if (!cancelled) setError(err.message);
      })
      .finally(() => {
        if (!cancelled) setLoading(false);
      });
    return () => {
      cancelled = true;
    };
  }, [availableOnly, appliedFilters]);

  function handleSubmit(event) {
    event.preventDefault();
    setLoading(true);
    setError("");
    setAppliedFilters({ ...filters });
  }

  function clearFilters() {
    setFilters(emptyFilters);
    setLoading(true);
    setError("");
    setAppliedFilters({ ...emptyFilters });
  }

  return (
    <main className="animals-section">
      <div className="section-title">{availableOnly ? "ANIMALI IN ADOZIONE" : "I NOSTRI ANIMALI"}</div>
      <form className="filter-container" onSubmit={handleSubmit}>
        <div className="filter-title">FILTRA I NOSTRI ANIMALI</div>
        <div className="filter-grid">
          <TextInput label="Nome" name="nome" value={filters.nome} setForm={setFilters} placeholder="Cerca per nome" />
          <SelectInput label="Sesso" name="sesso" value={filters.sesso} setForm={setFilters} options={genderOptions} />
          <SelectInput label="Specie" name="specie" value={filters.specie} setForm={setFilters} options={speciesOptions} />
          <TextInput label="Razza" name="razza" value={filters.razza} setForm={setFilters} placeholder="Cerca per razza" />
          <TextInput label="Peso massimo" name="pesoMax" type="number" value={filters.pesoMax} setForm={setFilters} min="0" step="0.1" />
          <TextInput label="Eta massima" name="etaMax" type="number" value={filters.etaMax} setForm={setFilters} min="0" />
        </div>
        <div className="filter-buttons">
          <button type="submit" className="filter-btn">
            Applica Filtri
          </button>
          <button type="button" className="filter-btn clear-btn" onClick={clearFilters}>
            Cancella Filtri
          </button>
        </div>
      </form>

      <div className="animals-table-container">
        <Alert type="error">{error}</Alert>
        {loading ? (
          <Loading />
        ) : rows.length === 0 ? (
          <div className="no-results visible">Nessun animale trovato con i criteri selezionati.</div>
        ) : (
          <table>
            <thead>
              <tr>
                <th className="header-btn">Nome</th>
                <th className="header-btn">Sesso</th>
                <th className="header-btn">Specie</th>
                <th className="header-btn">Razza</th>
                <th className="header-btn">Peso</th>
                <th className="header-btn">Eta</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((animal) => (
                <tr className="table-row" key={animal.id}>
                  <td data-label="Nome">
                    <Link to={`/animali/${animal.id}`}>{valueOrDash(animal.name)}</Link>
                  </td>
                  <td data-label="Sesso">{valueOrDash(animal.gender)}</td>
                  <td data-label="Specie">{valueOrDash(animal.species)}</td>
                  <td data-label="Razza">{valueOrDash(animal.breed)}</td>
                  <td data-label="Peso">{animal.weight ? `${animal.weight} kg` : "N/A"}</td>
                  <td data-label="Eta">{ageFromBirthDate(animal.birthDate)}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </main>
  );
}
