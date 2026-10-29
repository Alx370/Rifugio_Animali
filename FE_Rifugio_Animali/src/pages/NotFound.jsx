import { Link } from "../router";

export default function NotFound() {
  return (
    <main className="registration-section">
      <div className="section-title">PAGINA NON TROVATA</div>
      <div className="container compact">
        <Link to="/" className="filter-btn">
          Torna alla home
        </Link>
      </div>
    </main>
  );
}
