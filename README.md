# Learning-Project-Catarsi

Un sistema di gestione per rifugi animali sviluppato come progetto di apprendimento utilizzando Spring Boot e tecnologie moderne.

## Descrizione

Catarsi è un'applicazione web completa progettata per gestire le operazioni quotidiane di un rifugio animali. Il sistema permette di:

- Registrare e gestire gli animali ospitati
- Tracciare le informazioni mediche e comportamentali
- Gestire le adozioni e i potenziali adottanti
- Monitorare le donazioni

## Tecnologie Utilizzate

- **Backend**: Spring Boot
- **Database**: SQL (configurazione tramite `data.sql` e `schema.sql`)
- **Frontend**: HTML/CSS/JavaScript con template engine
- **Build Tool**: Maven
- **Architettura**: MVC (Model-View-Controller)

## 🏗️ Struttura del Progetto

```
src/
├── main/
│   ├── java/
│   │   └── com/catarsi/Rifugio_Animali/
│   │       ├── api/           # API REST endpoints
│   │       ├── config/        # Configurazioni Login
│   │       ├── controller/    # Controller MVC
│   │       ├── model/         # Entità e modelli dati
│   │       ├── repos/         # Repository per accesso dati
│   │       ├── services/      # Logica di business
│   │       └── sign_in/       # Gestione autenticazione della Registrazione
│   └── resources/
│       ├── static/
│       │   ├── css/          # Fogli di stile CSS
│       │   └── image/        # Immagini e risorse
│       └── templates/        # Template HTML
└── test/                     # Test unitari
```

## Installazione e Avvio

### Prerequisiti

- Java 11 o superiore
- Maven 3.6+
- Database SQL (MySQL)

### Passi per l'installazione

1. **Clona il repository**
   ```bash
   git clone https://github.com/YaroslavNechainikov/Learning-Project-Catarsi.git
   cd Learning-Project-Catarsi
   ```

2. **Configura il database**
    - Modifica `application.properties` con i tuoi parametri di connessione
    - e copia i file `schema.sql` e `data.sql` nella cartella `src/main/resources` in MySQL

3. **Compila il progetto**
   ```bash
   mvn clean compile
   ```

4. **Avvia l'applicazione**
   ```bash
   mvn spring-boot:run
   ```

5. **Accedi all'applicazione**
    - Apri il browser e vai su `http://localhost:8080`

## Funzionalità Principali

### Gestione del Rifugio
- Registrazione nuovi animali
- Storico medico e Diario comportamentale
- Stato di adozione
- Donazioni

### Sistema di Autenticazione
- Login per staff e amministratori
- Gestione permessi e ruoli
- Area riservata per operazioni sensibili

### Interfaccia Web
- Dashboard intuitiva
- Responsive design
- Interfaccia user-friendly

## Database

Il progetto include:
- `schema.sql`: Struttura delle tabelle
- `data.sql`: Dati di esempio per testing

## Testing

Esegui i test con:
```bash
mvn test
```

## Scopo Didattico

Questo progetto è stato sviluppato come esercizio di apprendimento per:
- Architettura MVC con Spring Boot
- Gestione database con Spring Data JPA
- Sviluppo di API REST
- Integrazione frontend/backend
- Best practices nello sviluppo Java

## Autori

- GitHub: [@YaroslavNechainikov](https://github.com/YaroslavNechainikov)
- GitHub [@Alx370](https://github.com/Alx370)
- GitHub [@Daniela15P](https://github.com/Daniela15P)
- GitHub [@Omarben05](https://github.com/Omarben05)
