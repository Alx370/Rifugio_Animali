import { useState } from "react";
import { apiRequest } from "../api";
import Alert from "../components/Alert";
import { navigate } from "../navigation";
import { authFromLogin, isAdmin } from "../utils/auth";

export default function LoginPage({ onLogin }) {
  const [form, setForm] = useState({ email: "", password: "" });
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();
    setError("");
    setLoading(true);
    try {
      const response = await apiRequest("/auth/login", {
        method: "POST",
        body: form,
        tokenOverride: ""
      });
      const auth = authFromLogin(response, form.email);
      onLogin(auth);
      navigate(isAdmin(auth) ? "/gest" : "/animali");
    } catch (err) {
      setError(err.status === 401 ? "Email o password non validi." : err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <main className="registration-section">
      <div className="section-title">LOGIN</div>
      <div className="container">
        <Alert type="error">{error}</Alert>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Email</label>
            <input
              type="email"
              value={form.email}
              onChange={(event) => setForm((prev) => ({ ...prev, email: event.target.value }))}
              required
            />
          </div>
          <div className="form-group">
            <label>Password</label>
            <input
              type="password"
              value={form.password}
              onChange={(event) => setForm((prev) => ({ ...prev, password: event.target.value }))}
              required
            />
          </div>
          <button type="submit" disabled={loading}>
            {loading ? "Accesso..." : "Login"}
          </button>
        </form>
      </div>
    </main>
  );
}
