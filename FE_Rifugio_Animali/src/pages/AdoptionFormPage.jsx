import { useEffect, useState } from "react";
import { apiPage, apiRequest } from "../api";
import Alert from "../components/Alert";
import { SelectInput, TextInput } from "../components/FormControls";
import Loading from "../components/Loading";
import { animalLabel, compactPayload, pageContent, personName, today } from "../utils/formatters";

export default function AdoptionFormPage({ auth, animalId }) {
  const [animals, setAnimals] = useState([]);
  const [form, setForm] = useState({
    animal: animalId || "",
    adoptionDate: today(),
    note: ""
  });
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    let cancelled = false;
    apiPage("/animals", { disponibileAdozione: true, size: 300 })
      .then((page) => {
        if (!cancelled) setAnimals(pageContent(page));
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
  }, []);

  async function handleSubmit(event) {
    event.preventDefault();
    setError("");
    setMessage("");
    try {
      await apiRequest("/adoptions", {
        method: "POST",
        body: compactPayload({
          animal: Number(form.animal),
          adoptionDate: form.adoptionDate,
          note: form.note,
          status: "RICHIESTA"
        })
      });
      setMessage("Richiesta di adozione inviata.");
    } catch (err) {
      setError(err.message);
    }
  }

  return (
    <main className="form-page">
      <div className="form-container wide">
        <h2>Adotta</h2>
        <Alert type="success">{message}</Alert>
        <Alert type="error">{error}</Alert>
        {loading ? (
          <Loading />
        ) : (
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Utente</label>
              <span className="readonly-control">
                {personName(auth.user)} ({auth.user.email})
              </span>
            </div>
            <SelectInput
              label="Animale da adottare"
              name="animal"
              value={form.animal}
              setForm={setForm}
              required
              options={animals.map((animal) => ({ value: animal.id, label: animalLabel(animal) }))}
            />
            <TextInput label="Data richiesta" name="adoptionDate" type="date" value={form.adoptionDate} setForm={setForm} required />
            <div className="form-group">
              <label>Note</label>
              <textarea value={form.note} onChange={(event) => setForm((prev) => ({ ...prev, note: event.target.value }))} />
            </div>
            <button type="submit" className="btn-primary">
              Conferma adozione
            </button>
          </form>
        )}
      </div>
    </main>
  );
}
