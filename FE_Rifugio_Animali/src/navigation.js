export function navigate(to) {
  window.history.pushState({}, "", to);
  window.dispatchEvent(new Event("app:navigate"));
  window.scrollTo({ top: 0, behavior: "smooth" });
}

export function currentRoute() {
  return {
    path: window.location.pathname.replace(/\/+$/, "") || "/",
    query: new URLSearchParams(window.location.search)
  };
}
