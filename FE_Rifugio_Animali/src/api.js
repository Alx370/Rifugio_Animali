import { isSessionValid } from "./utils/auth.js";

const API_PREFIX = "/api";
const AUTH_KEY = "rifugio-auth";

export function loadStoredAuth() {
  try {
    const auth = JSON.parse(localStorage.getItem(AUTH_KEY));
    return isSessionValid(auth) ? auth : null;
  } catch {
    return null;
  }
}

export function storeAuth(auth) {
  localStorage.setItem(AUTH_KEY, JSON.stringify(auth));
}

export function removeStoredAuth() {
  localStorage.removeItem(AUTH_KEY);
}

export async function apiRequest(path, options = {}) {
  const storedAuth = loadStoredAuth();
  const headers = {
    Accept: "application/json",
    ...(options.body ? { "Content-Type": "application/json" } : {}),
    ...options.headers
  };

  const token = options.tokenOverride ?? storedAuth?.token;
  if (token) {
    headers.Authorization = token;
  }

  const response = await fetch(`${API_PREFIX}${path}`, {
    method: options.method || "GET",
    headers,
    body: options.body ? JSON.stringify(options.body) : undefined
  });

  if (!response.ok) {
    let detail = await response.text();
    try {
      const payload = JSON.parse(detail);
      detail = payload.message || payload.error || JSON.stringify(payload);
    } catch { /* Il backend puo restituire anche testo semplice o HTML. */ }
    const error = new Error(detail || `Richiesta fallita (${response.status})`);
    error.status = response.status;
    throw error;
  }

  if (response.status === 204) {
    return null;
  }

  const contentType = response.headers.get("content-type") || "";
  return contentType.includes("application/json") ? response.json() : response.text();
}

export async function apiPage(path, params = {}) {
  const search = new URLSearchParams();
  Object.entries({ size: 100, ...params }).forEach(([key, value]) => {
    if (value !== undefined && value !== null && value !== "") {
      search.set(key, value);
    }
  });
  const suffix = search.toString() ? `?${search.toString()}` : "";
  return apiRequest(`${path}${suffix}`);
}
