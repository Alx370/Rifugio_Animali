-- popolamento delle tabelle
create database rifugio_animali;
use rifugio_animali;
-- creazione delle tabelle

CREATE TABLE IF NOT EXISTS Utente (
  Id_utente     INT PRIMARY KEY AUTO_INCREMENT,
  nome          VARCHAR(30) NOT NULL,
  cognome       VARCHAR(30) NOT NULL,
  email         VARCHAR(100) NOT NULL UNIQUE,
  password      VARCHAR(255) NOT NULL,
  telefono      VARCHAR(20),
  sesso         CHAR(1),
  data_nascita  DATE,
  ruolo         VARCHAR(20) NOT NULL DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS Ente (
  Id_ente     INT PRIMARY KEY AUTO_INCREMENT,
  nome        VARCHAR(100) NOT NULL,
  email       VARCHAR(100),
  telefono    VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Donazione (
  Id_donazione     INT PRIMARY KEY AUTO_INCREMENT,
  Id_utente        INT,
  Id_ente          INT,
  data             DATE NOT NULL,
  somma            DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_don_utente FOREIGN KEY (id_utente) REFERENCES Utente(id_utente),
  CONSTRAINT fk_don_ente FOREIGN KEY (id_ente) REFERENCES Ente(id_ente)
);

CREATE TABLE IF NOT EXISTS Dottore (
  Id_dottore   INT PRIMARY KEY AUTO_INCREMENT,
  nome         VARCHAR(30) NOT NULL,
  cognome      VARCHAR(30) NOT NULL,
  email        VARCHAR(100) NOT NULL UNIQUE,
  telefono     VARCHAR(20),
  sesso        CHAR(1)
);

CREATE TABLE IF NOT EXISTS Animale (
  Id_animale          INT PRIMARY KEY AUTO_INCREMENT,
  specie              VARCHAR(20) NOT NULL,
  nome                VARCHAR(20) NULL,
  data_arrivo         DATE NOT NULL,
  data_adozione       DATE,
  razza               VARCHAR(20),
  sesso               CHAR(1) NOT NULL,
  peso                DECIMAL(5,2) NOT NULL,
  eta                 INT,
  taglia              VARCHAR(20) NOT NULL,
  colore              VARCHAR(30) NOT NULL,
  segni_particolari   TEXT
);

CREATE TABLE IF NOT EXISTS Adozione (
  Id_adozione     INT PRIMARY KEY AUTO_INCREMENT,
  Id_animale      INT NOT NULL UNIQUE,
  Id_utente       INT NOT NULL,
  data_adozione   DATE NOT NULL,
  CONSTRAINT fk_adozione_animale FOREIGN KEY (id_animale) REFERENCES Animale(id_animale),
  CONSTRAINT fk_adozione_utente FOREIGN KEY (id_utente) REFERENCES Utente(id_utente)
);

CREATE TABLE IF NOT EXISTS Visita (
  Id_visita      INT PRIMARY KEY AUTO_INCREMENT,
  Id_animale     INT NOT NULL,
  Id_dottore     INT NOT NULL,
  data_visita    DATE NOT NULL,
  descrizione    TEXT,
  CONSTRAINT fk_visita_animale FOREIGN KEY (id_animale) REFERENCES Animale(id_animale),
  CONSTRAINT fk_visita_dottore FOREIGN KEY (id_dottore) REFERENCES Dottore(id_dottore)
);

CREATE TABLE IF NOT EXISTS Admin_app (
  Id_admin    INT PRIMARY KEY AUTO_INCREMENT,
  email       VARCHAR(100) NOT NULL UNIQUE,
  password    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS diario (
  Id_diario    INT PRIMARY KEY AUTO_INCREMENT,
  Id_animale   INT ,
  storia_animale TEXT,
  stato_salute    TEXT NOT NULL,
  stato_comportamentale TEXT NOT NULL,
  vaccinazioni TEXT,
  operazioni_effettuate TEXT,
  CONSTRAINT FK_id_animale FOREIGN KEY (Id_animale) REFERENCES Animale(Id_animale)
);