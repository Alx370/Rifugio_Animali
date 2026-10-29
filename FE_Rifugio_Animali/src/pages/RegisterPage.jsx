import { useState } from "react";
import { apiRequest } from "../api";
import Alert from "../components/Alert";
import { SelectInput, TextInput } from "../components/FormControls";
import { genderOptions } from "../constants";
import { compactPayload } from "../utils/formatters";

const emptyForm = {
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  phone: "",
  gender: "",
  birthDate: ""
};

export default function RegisterPage() {
  const [form, setForm] = useState(emptyForm);
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();
    setError("");
    setMessage("");
    setLoading(true);
    try {
      await apiRequest("/users/register", {
        method: "POST",
        body: compactPayload(form)
      });
      setMessage("Registrazione completata. Ora puoi effettuare il login.");
      setForm(emptyForm);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <main className="registration-section">
      <div className="section-title">SIGN IN</div>
      <div className="container">
        <Alert type="success">{message}</Alert>
        <Alert type="error">{error}</Alert>
        <form onSubmit={handleSubmit}>
          <div className="form-grid">
            <TextInput label="Nome" name="firstName" value={form.firstName} setForm={setForm} required />
            <TextInput label="Cognome" name="lastName" value={form.lastName} setForm={setForm} required />
            <TextInput label="Email" name="email" type="email" value={form.email} setForm={setForm} required />
            <TextInput label="Password" name="password" type="password" value={form.password} setForm={setForm} required />
            <TextInput label="Telefono" name="phone" value={form.phone} setForm={setForm} />
            <SelectInput label="Sesso" name="gender" value={form.gender} setForm={setForm} options={genderOptions} />
            <TextInput label="Data di nascita" name="birthDate" type="date" value={form.birthDate} setForm={setForm} />
          </div>
          <button type="submit" disabled={loading}>
            {loading ? "Registrazione..." : "Registrati"}
          </button>
        </form>
      </div>
    </main>
  );
}
