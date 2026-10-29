import { Link } from "../router";
import { isAdmin } from "../utils/auth";

function Header({ auth, onLogout }) {
  return (
    <header>
      <nav>
        <Link to="/" className="logo">
          <img src="/image/logo.png" alt="Logo Catarsi Group" />
          CATARSI GROUP
        </Link>
        <ul className="nav-links">
          <li>
            <Link to="/animali">Animali</Link>
          </li>
          <li>
            <Link to="/adozioni/visualizza">Adottami</Link>
          </li>
          {isAdmin(auth) && (
            <li>
              <Link to="/gest">Backoffice</Link>
            </li>
          )}
          {auth ? (
            <li>
              <button className="logout-button" type="button" onClick={onLogout}>
                Logout
              </button>
            </li>
          ) : (
            <>
              <li>
                <Link to="/login">Login</Link>
              </li>
              <li>
                <Link to="/signin">Sign In</Link>
              </li>
            </>
          )}
        </ul>
        <Link to="/donazioni/form" className="contact-btn">
          DONA ORA
        </Link>
      </nav>
    </header>
  );
}

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-logo">
          <img src="/image/logo.png" alt="Logo Catarsi" />
        </div>
        <div className="footer-right">
          <div className="social-icons">
            <a href="https://facebook.com/catarsigroup" target="_blank" rel="noreferrer" className="social-icon">
              <img src="/image/facebook-icon.svg" alt="Facebook" className="social-svg" />
            </a>
            <a href="https://instagram.com/catarsigroup" target="_blank" rel="noreferrer" className="social-icon">
              <img src="/image/instagram-icon.svg" alt="Instagram" className="social-svg" />
            </a>
            <a href="https://tiktok.com/catarsigroup" target="_blank" rel="noreferrer" className="social-icon">
              <img src="/image/tiktok-icon.svg" alt="TikTok" className="social-svg" />
            </a>
          </div>
          <div className="footer-credits">
            <p>Crediti alla Fondazione Catarsi</p>
          </div>
        </div>
      </div>
    </footer>
  );
}

export function RequireAuth({ auth, admin = false, children }) {
  if (!auth) {
    return (
      <main className="registration-section">
        <div className="section-title">ACCESSO RICHIESTO</div>
        <div className="container compact">
          <p>Per continuare devi effettuare il login.</p>
          <div className="button-row">
            <Link to="/login" className="filter-btn">
              Login
            </Link>
            <Link to="/signin" className="filter-btn secondary-btn">
              Sign In
            </Link>
          </div>
        </div>
      </main>
    );
  }

  if (admin && !isAdmin(auth)) {
    return (
      <main className="registration-section">
        <div className="section-title">AREA RISERVATA</div>
        <div className="container compact">
          <p>Il tuo account non ha i permessi per aprire questa sezione.</p>
          <Link to="/" className="filter-btn">
            Torna alla home
          </Link>
        </div>
      </main>
    );
  }

  return children;
}

export default function Layout({ auth, onLogout, children }) {
  return (
    <div className="app-shell">
      <Header auth={auth} onLogout={onLogout} />
      {children}
      <Footer />
    </div>
  );
}
