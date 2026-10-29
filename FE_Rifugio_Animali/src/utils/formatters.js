export const today = () => new Date().toISOString().slice(0, 10);

export function formatDate(value) {
  if (!value) return "N/A";
  const [year, month, day] = String(value).slice(0, 10).split("-");
  return year && month && day ? `${day}/${month}/${year}` : value;
}

export function formatMoney(value) {
  if (value === undefined || value === null || value === "") return "N/A";
  return new Intl.NumberFormat("it-IT", {
    style: "currency",
    currency: "EUR"
  }).format(Number(value));
}

export function ageFromBirthDate(value) {
  if (!value) return "N/A";
  const birth = new Date(`${value}T00:00:00`);
  const now = new Date();
  let age = now.getFullYear() - birth.getFullYear();
  const monthDelta = now.getMonth() - birth.getMonth();
  if (monthDelta < 0 || (monthDelta === 0 && now.getDate() < birth.getDate())) {
    age -= 1;
  }
  return age === 1 ? "1 anno" : `${Math.max(age, 0)} anni`;
}

export function valueOrDash(value) {
  return value === undefined || value === null || value === "" ? "N/A" : value;
}

export function personName(user) {
  if (!user) return "N/A";
  const firstName = user.firstName || user.nome;
  const lastName = user.lastName || user.cognome;
  return [firstName, lastName].filter(Boolean).join(" ") || user.email || "N/A";
}

export function animalLabel(animal) {
  if (!animal) return "N/A";
  return [animal.name || animal.nome || `Animale #${animal.id}`, animal.species || animal.specie]
    .filter(Boolean)
    .join(" - ");
}

export function pageContent(page) {
  return Array.isArray(page?.content) ? page.content : [];
}

export function compactPayload(payload) {
  return Object.fromEntries(
    Object.entries(payload).filter(([, value]) => value !== undefined && value !== null && value !== "")
  );
}
