import { useEffect, useState } from "react";
import { apiPage, apiRequest } from "../api";
import Alert from "../components/Alert";
import { SelectInput, TextInput } from "../components/FormControls";
import { compactPayload, formatMoney, pageContent, personName, today } from "../utils/formatters";

export default function DonationFormPage({ auth }) {
  const [organizations, setOrganizations] = useState([]);
  const [form, setForm] = useState({ organization: "", date: today(), sum: "0" });
  const [customAmount, setCustomAmount] = useState(false);
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    let cancelled = false;
    apiPage("/organizations", { size: 300 })
      .then((page) => {
        if (cancelled) return;
        const list = pageContent(page);
        setOrganizations(list);
        if (list[0]) {
          setForm((prev) => ({ ...prev, organization: String(list[0].id) }));
        }
      })
      .catch((err) => {
        if (!cancelled) setError(err.message);
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
      await apiRequest("/donations", {
        method: "POST",
        body: compactPayload({
          organization: Number(form.organization),
          date: form.date,
          sum: Number(form.sum)
        })
      });
      setMessage("Donazione registrata.");
      setForm((prev) => ({ ...prev, sum: "0" }));
      setCustomAmount(false);
    } catch (err) {
      setError(err.message);
    }
  }

  function chooseAmount(amount) {
    setCustomAmount(false);
    setForm((prev) => ({ ...prev, sum: String(amount) }));
  }

  return (
    <main className="donation-main">
      <section className="donation-hero">
        <h1>Sostieni Rifugio Catarsi</h1>
        <p>Ogni donazione ci aiuta a prenderci cura degli animali abbandonati.</p>
      </section>

      <div className="content-grid">
        <section className="support-section">
          <h2 className="section-title">IL TUO AIUTO FA LA DIFFERENZA</h2>
          <div className="support-options">
            <SupportOption title="10 euro al mese" text="Cibo per un cane" />
            <SupportOption title="50 euro" text="Visita veterinaria" />
            <SupportOption title="100 euro" text="Sistemazione mensile" />
            <SupportOption title="200 euro" text="Emergenza chirurgica" />
          </div>
        </section>

        <section className="donation-section">
          <h2 className="section-title">FAI UNA DONAZIONE</h2>
          <Alert type="success">{message}</Alert>
          <Alert type="error">{error}</Alert>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Utente</label>
              <span className="readonly-control">
                {personName(auth.user)} ({auth.user.email})
              </span>
            </div>
            <SelectInput
              label="Ente"
              name="organization"
              value={form.organization}
              setForm={setForm}
              required
              options={organizations.map((organization) => ({
                value: organization.id,
                label: organization.name
              }))}
            />
            <div className="donation-amounts">
              {[10, 25, 50, 100, 200].map((amount) => (
                <button
                  key={amount}
                  type="button"
                  className={`amount-btn ${Number(form.sum) === amount && !customAmount ? "selected" : ""}`}
                  onClick={() => chooseAmount(amount)}
                >
                  {formatMoney(amount)}
                </button>
              ))}
              <button type="button" className={`amount-btn ${customAmount ? "selected" : ""}`} onClick={() => setCustomAmount(true)}>
                Altro
              </button>
            </div>
            {customAmount && (
              <TextInput label="Importo personalizzato" name="sum" type="number" value={form.sum} setForm={setForm} min="1" step="0.01" required />
            )}
            <TextInput label="Data di donazione" name="date" type="date" value={form.date} setForm={setForm} required />
            <div className="donation-total">Importo da donare: {formatMoney(form.sum)}</div>
            <button type="submit" className="donate-btn">
              Dona ora
            </button>
          </form>
        </section>
      </div>
    </main>
  );
}

function SupportOption({ title, text }) {
  return (
    <div className="support-option">
      <div className="details">
        <h3>{title}</h3>
        <p>{text}</p>
      </div>
    </div>
  );
}
