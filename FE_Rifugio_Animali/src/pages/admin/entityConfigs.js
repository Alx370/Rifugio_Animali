import { genderOptions, requestStatusOptions, roleOptions } from "../../constants";
import { animalLabel, formatDate, formatMoney, personName, today } from "../../utils/formatters";

export const entityConfigs = {
  animals: {
    title: "Gestione Animali",
    path: "/animals",
    columns: [
      { header: "Nome", render: (row) => row.name },
      { header: "Specie", render: (row) => row.species },
      { header: "Razza", render: (row) => row.breed },
      { header: "Sesso", render: (row) => row.gender },
      { header: "Peso", render: (row) => (row.weight ? `${row.weight} kg` : "") },
      { header: "Disponibile", render: (row) => (row.availableForAdoption ? "Si" : "No") }
    ],
    fields: [
      { name: "name", label: "Nome", required: true },
      { name: "species", label: "Specie", required: true },
      { name: "microchip", label: "Microchip" },
      { name: "arrivalDate", label: "Data di arrivo", type: "date", required: true },
      { name: "birthDate", label: "Data di nascita", type: "date" },
      { name: "adoptionDate", label: "Data di adozione", type: "date" },
      { name: "breed", label: "Razza" },
      { name: "gender", label: "Sesso", type: "select", options: genderOptions, required: true },
      { name: "weight", label: "Peso", type: "number", step: "0.1", min: "0", required: true },
      { name: "size", label: "Taglia", required: true },
      { name: "color", label: "Colore", required: true },
      { name: "distinctiveMarks", label: "Segni particolari", type: "textarea" },
      { name: "spayedNeutered", label: "Sterilizzato", type: "checkbox" },
      { name: "availableForAdoption", label: "Disponibile per adozione", type: "checkbox", defaultValue: true }
    ]
  },
  adoptions: {
    title: "Gestione Adozioni",
    path: "/adoptions",
    columns: [
      { header: "Animale", render: (row) => animalLabel(row.animal) },
      { header: "Utente", render: (row) => personName(row.user) },
      { header: "Data", render: (row) => formatDate(row.adoptionDate) },
      { header: "Stato", render: (row) => row.status },
      { header: "Note", render: (row) => row.note }
    ],
    fields: [
      {
        name: "animal",
        label: "Animale",
        type: "select",
        source: "animals",
        valueType: "number",
        optionLabel: animalLabel,
        from: (row) => row.animal?.id || "",
        required: true
      },
      { name: "adoptionDate", label: "Data adozione", type: "date", defaultValue: today(), required: true },
      { name: "note", label: "Note", type: "textarea" },
      { name: "status", label: "Stato", type: "select", options: requestStatusOptions, defaultValue: "RICHIESTA" }
    ]
  },
  donations: {
    title: "Gestione Donazioni",
    path: "/donations",
    columns: [
      { header: "Utente", render: (row) => personName(row.user) },
      { header: "Ente", render: (row) => row.organization?.name },
      { header: "Data", render: (row) => formatDate(row.date) },
      { header: "Somma", render: (row) => formatMoney(row.sum) }
    ],
    fields: [
      {
        name: "organization",
        label: "Ente",
        type: "select",
        source: "organizations",
        valueType: "number",
        optionLabel: (row) => row.name,
        from: (row) => row.organization?.id || "",
        required: true
      },
      { name: "date", label: "Data donazione", type: "date", defaultValue: today(), required: true },
      { name: "sum", label: "Somma", type: "number", step: "0.01", min: "1", required: true }
    ]
  },
  veterinarians: {
    title: "Gestione Dottori",
    path: "/veterinarians",
    columns: [
      { header: "Nome", render: (row) => row.firstName },
      { header: "Cognome", render: (row) => row.lastName },
      { header: "Email", render: (row) => row.email },
      { header: "Telefono", render: (row) => row.phone },
      { header: "Sesso", render: (row) => row.gender }
    ],
    fields: [
      { name: "firstName", label: "Nome", required: true },
      { name: "lastName", label: "Cognome", required: true },
      { name: "email", label: "Email", type: "email", required: true },
      { name: "phone", label: "Telefono" },
      { name: "gender", label: "Sesso", type: "select", options: genderOptions }
    ]
  },
  users: {
    title: "Gestione Utenti",
    path: "/users",
    columns: [
      { header: "Nome", render: (row) => personName(row) },
      { header: "Email", render: (row) => row.email },
      { header: "Telefono", render: (row) => row.phone },
      { header: "Sesso", render: (row) => row.gender },
      { header: "Ruolo", render: (row) => row.role },
      { header: "Attivo", render: (row) => (row.active ? "Si" : "No") }
    ],
    fields: [
      { name: "firstName", label: "Nome", required: true },
      { name: "lastName", label: "Cognome", required: true },
      { name: "email", label: "Email", type: "email", required: true },
      { name: "password", label: "Password", type: "password", requiredOnCreate: true, from: () => "" },
      { name: "phone", label: "Telefono" },
      { name: "gender", label: "Sesso", type: "select", options: genderOptions },
      { name: "birthDate", label: "Data di nascita", type: "date" },
      { name: "role", label: "Ruolo", type: "select", options: roleOptions, defaultValue: "USER" },
      { name: "active", label: "Attivo", type: "checkbox", defaultValue: true }
    ]
  },
  organizations: {
    title: "Gestione Enti",
    path: "/organizations",
    columns: [
      { header: "Nome", render: (row) => row.name },
      { header: "Email", render: (row) => row.email },
      { header: "Telefono", render: (row) => row.telephone }
    ],
    fields: [
      { name: "name", label: "Nome", required: true },
      { name: "email", label: "Email", type: "email" },
      { name: "telephone", label: "Telefono" }
    ]
  },
  visits: {
    title: "Gestione Visite",
    path: "/visits",
    columns: [
      { header: "Data", render: (row) => formatDate(row.visitDate) },
      { header: "Animale", render: (row) => animalLabel(row.animal) },
      { header: "Utente", render: (row) => personName(row.user) },
      { header: "Dottore", render: (row) => personName(row.veterinarian) },
      { header: "Tipo", render: (row) => row.visitType },
      { header: "Costo", render: (row) => formatMoney(row.cost) },
      { header: "Stato", render: (row) => row.status }
    ],
    fields: [
      {
        name: "animal",
        label: "Animale",
        type: "select",
        source: "animals",
        valueType: "number",
        optionLabel: animalLabel,
        from: (row) => row.animal?.id || "",
        required: true
      },
      {
        name: "user",
        label: "Utente",
        type: "select",
        source: "users",
        valueType: "number",
        optionLabel: (row) => `${personName(row)} (${row.email})`,
        from: (row) => row.user?.id || "",
        required: true
      },
      {
        name: "veterinarian",
        label: "Dottore",
        type: "select",
        source: "veterinarians",
        valueType: "number",
        optionLabel: personName,
        from: (row) => row.veterinarian?.id || ""
      },
      { name: "visitDate", label: "Data visita", type: "date", defaultValue: today(), required: true },
      { name: "visitType", label: "Tipo visita" },
      { name: "description", label: "Descrizione", type: "textarea" },
      { name: "cost", label: "Costo", type: "number", step: "0.01", min: "0" },
      { name: "status", label: "Stato", type: "select", options: requestStatusOptions, defaultValue: "RICHIESTA" }
    ]
  },
  diaries: {
    title: "Gestione Diari",
    path: "/diaries",
    columns: [
      { header: "Animale", render: (row) => animalLabel(row.animal) },
      { header: "Stato salute", render: (row) => row.healthStatus },
      { header: "Comportamento", render: (row) => row.behavioralStatus },
      { header: "Vaccinazioni", render: (row) => row.vaccinations }
    ],
    fields: [
      {
        name: "animal",
        label: "Animale",
        type: "select",
        source: "animals",
        valueType: "number",
        optionLabel: animalLabel,
        from: (row) => row.animal?.id || "",
        required: true
      },
      { name: "animalStory", label: "Storia animale", type: "textarea" },
      { name: "healthStatus", label: "Stato salute", type: "textarea", required: true },
      { name: "behavioralStatus", label: "Stato comportamentale", type: "textarea", required: true },
      { name: "vaccinations", label: "Vaccinazioni", type: "textarea" },
      { name: "performedOperations", label: "Operazioni effettuate", type: "textarea" }
    ]
  }
};
