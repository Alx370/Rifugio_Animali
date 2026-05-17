CREATE OR REPLACE FUNCTION update_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE IF NOT EXISTS utente (
                                      id                SERIAL PRIMARY KEY,
                                      uuid              VARCHAR(30) NOT NULL UNIQUE,
    nome              VARCHAR(30) NOT NULL,
    cognome           VARCHAR(30) NOT NULL,
    email             VARCHAR(100) NOT NULL UNIQUE,
    password_hash     VARCHAR(255) NOT NULL,
    telefono          VARCHAR(20),
    sesso             CHAR(1) CHECK (sesso IN ('M', 'F', 'A')),
    data_nascita      DATE,
    ruolo             VARCHAR(20) NOT NULL DEFAULT 'USER',
    attivo            BOOLEAN DEFAULT TRUE,
    created_at        TIMESTAMP DEFAULT NOW(),
    updated_at        TIMESTAMP DEFAULT NOW()
    );

CREATE TRIGGER trg_utente_updated
    BEFORE UPDATE ON utente
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE INDEX idx_utente_email ON utente(email);

CREATE TABLE IF NOT EXISTS organization (
                                    id          SERIAL PRIMARY KEY,
                                    nome        VARCHAR(100) NOT NULL,
    email       VARCHAR(100),
    telefono    VARCHAR(20),
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
    );

CREATE TRIGGER trg_ente_updated
    BEFORE UPDATE ON organization
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE TABLE IF NOT EXISTS donation (
                                         id          SERIAL PRIMARY KEY,
                                         id_utente   INT NOT NULL,
                                         id_ente     INT NOT NULL,
                                         data        DATE NOT NULL,
                                         somma       DECIMAL(10,2) NOT NULL,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_don_utente FOREIGN KEY (id_utente) REFERENCES utente(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_don_ente   FOREIGN KEY (id_ente)   REFERENCES organization(id)   ON DELETE RESTRICT ON UPDATE CASCADE
    );

CREATE TRIGGER trg_donazione_updated
    BEFORE UPDATE ON donation
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE INDEX idx_donazione_utente ON donation(id_utente);

CREATE TABLE IF NOT EXISTS dottore (
                                       id            SERIAL PRIMARY KEY,
                                       nome          VARCHAR(30) NOT NULL,
    cognome       VARCHAR(30) NOT NULL,
    email         VARCHAR(100) NOT NULL UNIQUE,
    telefono      VARCHAR(20),
    sesso         CHAR(1) CHECK (sesso IN ('M', 'F', 'A')),
    created_at    TIMESTAMP DEFAULT NOW(),
    updated_at    TIMESTAMP DEFAULT NOW()
    );

CREATE TRIGGER trg_dottore_updated
    BEFORE UPDATE ON dottore
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE TABLE IF NOT EXISTS animale (
                                       id                  SERIAL PRIMARY KEY,
                                       specie              VARCHAR(20) NOT NULL,
    nome                VARCHAR(20),
    microchip           VARCHAR(20) UNIQUE,
    data_arrivo         DATE NOT NULL,
    data_nascita        DATE,
    data_adozione       DATE,
    razza               VARCHAR(20),
    sesso               CHAR(1) NOT NULL CHECK (sesso IN ('M', 'F', 'A')),
    peso                DECIMAL(5,2) NOT NULL,
    taglia              VARCHAR(20) NOT NULL,
    colore              VARCHAR(30) NOT NULL,
    segni_particolari   TEXT,
    sterilizzato        BOOLEAN DEFAULT FALSE,
    disponibile_adozione BOOLEAN DEFAULT TRUE,
    created_at          TIMESTAMP DEFAULT NOW(),
    updated_at          TIMESTAMP DEFAULT NOW()
    );

CREATE TRIGGER trg_animale_updated
    BEFORE UPDATE ON animale
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE INDEX idx_animale_specie       ON animale(specie);
CREATE INDEX idx_animale_disponibile  ON animale(disponibile_adozione);

CREATE TABLE IF NOT EXISTS adoption (
                                        id            SERIAL PRIMARY KEY,
                                        id_animale    INT NOT NULL UNIQUE,
                                        id_utente     INT NOT NULL,
                                        data_adozione DATE NOT NULL,
                                        note          TEXT,
                                        created_at    TIMESTAMP DEFAULT NOW(),
    updated_at    TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_adozione_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_adozione_utente  FOREIGN KEY (id_utente)  REFERENCES utente(id)  ON DELETE RESTRICT ON UPDATE CASCADE
    );

CREATE TRIGGER trg_adozione_updated
    BEFORE UPDATE ON adoption
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE TABLE IF NOT EXISTS visit (
                                      id            SERIAL PRIMARY KEY,
                                      id_animale    INT NOT NULL,
                                      id_dottore    INT NOT NULL,
                                      data_visita   DATE NOT NULL,
                                      tipo_visita   VARCHAR(50),
    descrizione   TEXT,
    costo         DECIMAL(8,2),
    created_at    TIMESTAMP DEFAULT NOW(),
    updated_at    TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_visita_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_visita_dottore FOREIGN KEY (id_dottore) REFERENCES dottore(id) ON DELETE RESTRICT ON UPDATE CASCADE
    );

CREATE TRIGGER trg_visita_updated
    BEFORE UPDATE ON visit
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();

CREATE INDEX idx_visita_animale ON visit(id_animale);

CREATE TABLE IF NOT EXISTS diary (
                                      id                      SERIAL PRIMARY KEY,
                                      id_animale              INT,
                                      storia_animale          TEXT,
                                      stato_salute            TEXT NOT NULL,
                                      stato_comportamentale   TEXT NOT NULL,
                                      vaccinazioni            TEXT,
                                      operazioni_effettuate   TEXT,
                                      data_aggiornamento      TIMESTAMP DEFAULT NOW(),
    created_at              TIMESTAMP DEFAULT NOW(),
    updated_at              TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_id_animale FOREIGN KEY (id_animale) REFERENCES animale(id) ON DELETE RESTRICT ON UPDATE CASCADE
    );

CREATE TRIGGER trg_diario_updated
    BEFORE UPDATE ON diary
    FOR EACH ROW EXECUTE FUNCTION update_timestamp();
