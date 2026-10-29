import { useEffect, useState } from "react";
import { apiPage } from "../../api";
import Alert from "../../components/Alert";
import Loading from "../../components/Loading";
import { Link } from "../../router";
import { formatMoney, pageContent } from "../../utils/formatters";

const cards = [
  ["animals", "Gestione Animali", "Animali ospitati", "/backoffice/animali", "animals"],
  ["adoptions", "Gestione Adozioni", "Richieste e adozioni", "/backoffice/adozioni", "adoptions"],
  ["donations", "Gestione Donazioni", "Totale donazioni", "/backoffice/donazioni", "donations"],
  ["visits", "Gestione Visite", "Visite veterinarie", "/backoffice/visite", "visits"],
  ["veterinarians", "Gestione Dottori", "Veterinari registrati", "/backoffice/dottori", "doctors"],
  ["users", "Gestione Utenti", "Account utenti", "/backoffice/utenti", "users"],
  ["organizations", "Gestione Enti", "Enti collegati", "/backoffice/enti", "entities"]
];

export default function AdminDashboard() {
  const [stats, setStats] = useState(null);
  const [error, setError] = useState("");

  useEffect(() => {
    let cancelled = false;
    const loaders = [
      ["animals", apiPage("/animals", { size: 1 })],
      ["adoptions", apiPage("/adoptions", { size: 1 })],
      ["donations", apiPage("/donations", { size: 500 })],
      ["visits", apiPage("/visits", { size: 1 })],
      ["veterinarians", apiPage("/veterinarians", { size: 1 })],
      ["users", apiPage("/users", { size: 1 })],
      ["organizations", apiPage("/organizations", { size: 1 })]
    ];
    Promise.all(loaders.map(([key, promise]) => promise.then((page) => [key, page])))
      .then((entries) => {
        if (cancelled) return;
        const data = Object.fromEntries(entries);
        const donationTotal = pageContent(data.donations).reduce((sum, donation) => sum + Number(donation.sum || 0), 0);
        setStats({ ...data, donationTotal });
      })
      .catch((err) => {
        if (!cancelled) setError(err.message);
      });
    return () => {
      cancelled = true;
    };
  }, []);

  return (
    <main className="main-content">
      <section className="welcome-section">
        <h1 className="welcome-title">Dashboard Gestionale</h1>
        <p className="welcome-subtitle">Catarsi Group</p>
      </section>
      <Alert type="error">{error}</Alert>
      {!stats ? (
        <Loading />
      ) : (
        <section className="dashboard-grid">
          {cards.map(([key, title, label, to, className]) => {
            const value = key === "donations" ? formatMoney(stats.donationTotal) : stats[key]?.totalElements ?? 0;
            const icon = title.replace("Gestione ", "").slice(0, 1);
            return (
              <Link to={to} className="card" key={key}>
                <div className={`card-icon ${className}`}>{icon}</div>
                <h3 className="card-title">{title}</h3>
                <p className="card-description">{label}</p>
                <div className="card-stats">
                  <span className="stat-number">{value}</span>
                  <span className="stat-label">totale</span>
                </div>
              </Link>
            );
          })}
        </section>
      )}
    </main>
  );
}
