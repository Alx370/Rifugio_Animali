import { useEffect, useState } from "react";
import { apiPage, apiRequest } from "../api";
import Alert from "../components/Alert";
import Loading from "../components/Loading";
import { Link } from "../router";
import { ageFromBirthDate, formatDate, pageContent, valueOrDash } from "../utils/formatters";

export default function AnimalDetailPage({ id, auth }) {
  const [animal, setAnimal] = useState(null);
  const [diaries, setDiaries] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    let cancelled = false;
    Promise.all([apiRequest(`/animals/${id}`), apiPage("/diaries", { size: 300 }).catch(() => ({ content: [] }))])
      .then(([animalPayload, diariesPage]) => {
        if (cancelled) return;
        setAnimal(animalPayload);
        setDiaries(pageContent(diariesPage).filter((diary) => diary.animal?.id === Number(id)));
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
  }, [id]);

  if (loading) {
    return (
      <main className="detail-page">
        <Loading />
      </main>
    );
  }

  if (error || !animal) {
    return (
      <main className="detail-page">
        <Alert type="error">{error || "Animale non trovato."}</Alert>
      </main>
    );
  }

  const canAdopt = animal.availableForAdoption && !animal.adoptionDate;

  return (
    <main className="detail-page">
      <div className="detail-container">
        <h1>Dettagli di {valueOrDash(animal.name)}</h1>
        <ul className="detail-list">
          <DetailItem label="Nome" value={animal.name} />
          <DetailItem label="Sesso" value={animal.gender} />
          <DetailItem label="Specie" value={animal.species} />
          <DetailItem label="Razza" value={animal.breed} />
          <DetailItem label="Peso" value={animal.weight ? `${animal.weight} kg` : ""} />
          <DetailItem label="Eta" value={ageFromBirthDate(animal.birthDate)} />
          <DetailItem label="Taglia" value={animal.size} />
          <DetailItem label="Colore" value={animal.color} />
          <DetailItem label="Data di arrivo" value={formatDate(animal.arrivalDate)} />
          <DetailItem label="Data di adozione" value={formatDate(animal.adoptionDate)} />
        </ul>

        <h1>Diario di {valueOrDash(animal.name)}</h1>
        {diaries.length === 0 ? (
          <div className="panel">Nessun diario disponibile.</div>
        ) : (
          <ul className="diary-list">
            {diaries.map((diary) => (
              <li key={diary.id}>
                <strong>Storia dell'animale</strong>
                <span>{valueOrDash(diary.animalStory)}</span>
                <strong>Stato di salute</strong>
                <span>{valueOrDash(diary.healthStatus)}</span>
                <strong>Stato comportamentale</strong>
                <span>{valueOrDash(diary.behavioralStatus)}</span>
                <strong>Vaccinazioni</strong>
                <span>{valueOrDash(diary.vaccinations)}</span>
                <strong>Operazioni effettuate</strong>
                <span>{valueOrDash(diary.performedOperations)}</span>
              </li>
            ))}
          </ul>
        )}

        <div className="button-row">
          <Link to="/animali" className="filter-btn secondary-btn">
            Torna alla lista
          </Link>
          {canAdopt && (
            <Link to={auth ? `/adozioni/form?animal=${animal.id}` : "/login"} className="adopt-button">
              Adotta {animal.name || "questo animale"}
            </Link>
          )}
        </div>
      </div>
    </main>
  );
}

function DetailItem({ label, value }) {
  return (
    <li>
      <strong>{label}:</strong>
      <span>{valueOrDash(value)}</span>
    </li>
  );
}
