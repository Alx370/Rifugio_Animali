export function isAdmin(auth) {
  return auth?.user?.role === "ADMIN" || auth?.user?.ruolo === "ADMIN";
}

function tokenClaims(token) {
  const payload = token.split(".")[1].replace(/-/g, "+").replace(/_/g, "/");
  const bytes = Uint8Array.from(atob(payload), (character) => character.charCodeAt(0));
  return JSON.parse(new TextDecoder().decode(bytes));
}

export function authFromLogin(response, email) {
  if (response.type !== "Bearer" || !response.token) {
    throw new Error("Risposta di autenticazione non valida.");
  }
  const claims = tokenClaims(response.token);
  return {
    token: `Bearer ${response.token}`,
    user: { email: claims.sub || email, role: claims.role }
  };
}

export function isSessionValid(auth) {
  if (!auth?.token?.startsWith("Bearer ") || !auth.user?.email) return false;
  try {
    return Number(tokenClaims(auth.token.slice(7)).exp) * 1000 > Date.now();
  } catch {
    return false;
  }
}
