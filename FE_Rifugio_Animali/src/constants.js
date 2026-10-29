export const requestStatusOptions = [
  { value: "RICHIESTA", label: "Richiesta" },
  { value: "APPROVATA", label: "Approvata" },
  { value: "RIFIUTATA", label: "Rifiutata" },
  { value: "ANNULLATA", label: "Annullata" },
  { value: "PROGRAMMATA", label: "Programmata" },
  { value: "COMPLETATA", label: "Completata" }
];

export const genderOptions = [
  { value: "M", label: "Maschio" },
  { value: "F", label: "Femmina" },
  { value: "A", label: "Altro" }
];

export const roleOptions = [
  { value: "USER", label: "Utente" },
  { value: "ADMIN", label: "Admin" }
];

export const speciesOptions = [
  { value: "Cane", label: "Cane" },
  { value: "Gatto", label: "Gatto" },
  { value: "Coniglio", label: "Coniglio" }
];

export const lookupPaths = {
  animals: "/animals",
  users: "/users",
  veterinarians: "/veterinarians",
  organizations: "/organizations"
};

export const backofficeRoutes = {
  animali: "animals",
  adozioni: "adoptions",
  donazioni: "donations",
  dottori: "veterinarians",
  utenti: "users",
  enti: "organizations",
  visite: "visits",
  diari: "diaries"
};
