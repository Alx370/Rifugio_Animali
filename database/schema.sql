CREATE OR REPLACE FUNCTION aggiorna_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.aggiornato_il = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS utente (
    id             SERIAL PRIMARY KEY,
    uuid           VARCHAR(30) NOT NULL UNIQUE,
    nome           VARCHAR(30) NOT NULL,
    cognome        VARCHAR(30) NOT NULL,
    email          VARCHAR(100) NOT NULL UNIQUE,
    password_hash  VARCHAR(255) NOT NULL,
    telefono       VARCHAR(20),
    sesso          CHAR(1) CHECK (sesso IN ('M', 'F', 'A')),
    data_nascita   DATE,
    ruolo          VARCHAR(20) NOT NULL DEFAULT 'USER',
    attivo         BOOLEAN NOT NULL DEFAULT TRUE,
    creato_il      TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il  TIMESTAMP NOT NULL DEFAULT NOW()
);

DROP TRIGGER IF EXISTS trg_utente_aggiornato ON utente;
CREATE TRIGGER trg_utente_aggiornato
    BEFORE UPDATE ON utente
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_utente_email ON utente(email);

CREATE TABLE IF NOT EXISTS ente (
    id             SERIAL PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    email          VARCHAR(100),
    telefono       VARCHAR(20),
    creato_il      TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il  TIMESTAMP NOT NULL DEFAULT NOW()
);

DROP TRIGGER IF EXISTS trg_ente_aggiornato ON ente;
CREATE TRIGGER trg_ente_aggiornato
    BEFORE UPDATE ON ente
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE TABLE IF NOT EXISTS dottore (
    id             SERIAL PRIMARY KEY,
    nome           VARCHAR(30) NOT NULL,
    cognome        VARCHAR(30) NOT NULL,
    email          VARCHAR(100) NOT NULL UNIQUE,
    telefono       VARCHAR(20),
    sesso          CHAR(1) CHECK (sesso IN ('M', 'F', 'A')),
    creato_il      TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il  TIMESTAMP NOT NULL DEFAULT NOW()
);

DROP TRIGGER IF EXISTS trg_dottore_aggiornato ON dottore;
CREATE TRIGGER trg_dottore_aggiornato
    BEFORE UPDATE ON dottore
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE TABLE IF NOT EXISTS animale (
    id                    SERIAL PRIMARY KEY,
    specie                VARCHAR(20) NOT NULL,
    nome                  VARCHAR(20),
    microchip             VARCHAR(20) UNIQUE,
    data_arrivo           DATE NOT NULL,
    data_nascita          DATE,
    data_adozione         DATE,
    razza                 VARCHAR(20),
    sesso                 CHAR(1) NOT NULL CHECK (sesso IN ('M', 'F', 'A')),
    peso                  DECIMAL(5,2) NOT NULL CHECK (peso > 0),
    taglia                VARCHAR(20) NOT NULL,
    colore                VARCHAR(30) NOT NULL,
    segni_particolari     TEXT,
    sterilizzato          BOOLEAN NOT NULL DEFAULT FALSE,
    disponibile_adozione  BOOLEAN NOT NULL DEFAULT TRUE,
    creato_il             TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il         TIMESTAMP NOT NULL DEFAULT NOW()
);

DROP TRIGGER IF EXISTS trg_animale_aggiornato ON animale;
CREATE TRIGGER trg_animale_aggiornato
    BEFORE UPDATE ON animale
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_animale_specie ON animale(specie);
CREATE INDEX IF NOT EXISTS idx_animale_disponibile_adozione ON animale(disponibile_adozione);

CREATE TABLE IF NOT EXISTS adozione (
    id              SERIAL PRIMARY KEY,
    id_animale      INT NOT NULL UNIQUE,
    id_utente       INT NOT NULL,
    data_adozione   DATE NOT NULL,
    stato           VARCHAR(20) NOT NULL DEFAULT 'RICHIESTA',
    note            TEXT,
    creato_il       TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il   TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_adozione_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_adozione_utente FOREIGN KEY (id_utente) REFERENCES utente(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT chk_adozione_stato CHECK (stato IN ('RICHIESTA', 'APPROVATA', 'RIFIUTATA', 'ANNULLATA'))
);

DROP TRIGGER IF EXISTS trg_adozione_aggiornato ON adozione;
CREATE TRIGGER trg_adozione_aggiornato
    BEFORE UPDATE ON adozione
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_adozione_utente ON adozione(id_utente);
CREATE INDEX IF NOT EXISTS idx_adozione_stato ON adozione(stato);

CREATE TABLE IF NOT EXISTS visita (
    id              SERIAL PRIMARY KEY,
    id_animale      INT NOT NULL,
    id_utente       INT NOT NULL,
    id_dottore      INT,
    data_visita     DATE NOT NULL,
    tipo_visita     VARCHAR(50),
    descrizione     TEXT,
    costo           DECIMAL(8,2) CHECK (costo IS NULL OR costo >= 0),
    stato           VARCHAR(20) NOT NULL DEFAULT 'RICHIESTA',
    creato_il       TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il   TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_visita_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_visita_utente FOREIGN KEY (id_utente) REFERENCES utente(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_visita_dottore FOREIGN KEY (id_dottore) REFERENCES dottore(id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT chk_visita_stato CHECK (stato IN ('RICHIESTA', 'CONFERMATA', 'COMPLETATA', 'ANNULLATA'))
);

DROP TRIGGER IF EXISTS trg_visita_aggiornato ON visita;
CREATE TRIGGER trg_visita_aggiornato
    BEFORE UPDATE ON visita
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_visita_animale ON visita(id_animale);
CREATE INDEX IF NOT EXISTS idx_visita_utente ON visita(id_utente);
CREATE INDEX IF NOT EXISTS idx_visita_dottore ON visita(id_dottore);
CREATE INDEX IF NOT EXISTS idx_visita_stato ON visita(stato);

CREATE TABLE IF NOT EXISTS donazione (
    id              SERIAL PRIMARY KEY,
    id_utente       INT NOT NULL,
    id_ente         INT NOT NULL,
    data_donazione  DATE NOT NULL,
    somma           DECIMAL(10,2) NOT NULL CHECK (somma > 0),
    creato_il       TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il   TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_donazione_utente FOREIGN KEY (id_utente) REFERENCES utente(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_donazione_ente FOREIGN KEY (id_ente) REFERENCES ente(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TRIGGER IF EXISTS trg_donazione_aggiornato ON donazione;
CREATE TRIGGER trg_donazione_aggiornato
    BEFORE UPDATE ON donazione
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_donazione_utente ON donazione(id_utente);
CREATE INDEX IF NOT EXISTS idx_donazione_ente ON donazione(id_ente);

CREATE TABLE IF NOT EXISTS diario (
    id                      SERIAL PRIMARY KEY,
    id_animale              INT NOT NULL,
    storia_animale          TEXT,
    stato_salute            TEXT NOT NULL,
    stato_comportamentale   TEXT NOT NULL,
    vaccinazioni            TEXT,
    operazioni_effettuate   TEXT,
    creato_il               TIMESTAMP NOT NULL DEFAULT NOW(),
    aggiornato_il           TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_diario_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TRIGGER IF EXISTS trg_diario_aggiornato ON diario;
CREATE TRIGGER trg_diario_aggiornato
    BEFORE UPDATE ON diario
    FOR EACH ROW EXECUTE FUNCTION aggiorna_timestamp();

CREATE INDEX IF NOT EXISTS idx_diario_animale ON diario(id_animale);
