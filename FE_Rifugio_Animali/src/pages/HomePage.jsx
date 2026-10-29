import { Link } from "../router";

const services = [
  {
    title: "ADOTTAMI",
    to: "/adozioni/visualizza",
    paragraphs: [
      "Scegliere di accogliere un nuovo compagno a quattro zampe nella vostra vita rappresenta un passo significativo.",
      "Venite a scoprire i nostri cani e gatti in attesa di trovare una famiglia tutta loro."
    ]
  },
  {
    title: "DONAZIONI",
    to: "/donazioni/form",
    paragraphs: [
      "Il tuo contributo puo fare la differenza. Sostieni le nostre attivita di cura e protezione degli animali.",
      "Ogni donazione, grande o piccola, aiuta a salvare delle vite."
    ]
  },
  {
    title: "INFORMAZIONI",
    paragraphs: [
      "Hai domande sui nostri servizi? Vuoi consigli per la cura del tuo animale?",
      "Il nostro team e disponibile per aiutarti."
    ]
  }
];

export default function HomePage() {
  return (
    <main>
      <section className="hero">
        <img src="/image/immagine-animali.jpg" alt="Animali del rifugio" className="hero-image" />
        <div className="hero-content">
          <p className="hero-kicker">Rifugio animali</p>
          <h1>Catarsi Group</h1>
          <p>Accogliamo, curiamo e accompagniamo ogni animale verso una nuova famiglia.</p>
          <div className="hero-actions">
            <Link to="/adozioni/visualizza" className="animal-list-btn">
              Scopri chi adottare
            </Link>
            <Link to="/donazioni/form" className="filter-btn secondary-btn">
              Sostieni il rifugio
            </Link>
          </div>
        </div>
      </section>

      <section className="services">
        <h2>I Nostri Servizi</h2>
        <div className="services-grid">
          {services.map((service) => (
            <article className="service-card" key={service.title}>
              <div className="card-header">
                {service.to ? <Link to={service.to}>{service.title}</Link> : service.title}
              </div>
              {service.paragraphs.map((text) => (
                <p key={text}>{text}</p>
              ))}
            </article>
          ))}
          <article className="service-card">
            <div className="card-header">CONTATTI</div>
            <ul>
              <li>+39 011 123 4567</li>
              <li>info@catarsigroup.it</li>
              <li>Via Garibaldi 1, Torino</li>
              <li>Lun-Sab 9:00-18:00</li>
            </ul>
          </article>
        </div>
      </section>

      <section className="animal-list-section">
        <Link to="/animali" className="animal-list-btn">
          La lista dei nostri animali
        </Link>
      </section>

      <section className="about" id="chi-siamo">
        <h2>CHI SIAMO?</h2>
        <p>
          Siamo una Fondazione nata dall'amore profondo per gli animali e dal desiderio concreto di cambiare il destino
          di tanti cuccioli abbandonati. Ogni giorno lavoriamo per dare una seconda possibilita a cani, gatti e altri
          piccoli amici che si ritrovano soli, spaventati o feriti.
        </p>
        <p>
          La nostra missione non e solo trovare un padrone, ma creare un legame vero e duraturo tra l'animale e la
          persona che lo accoglie.
        </p>
      </section>
    </main>
  );
}
