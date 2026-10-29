import { useEffect, useState } from "react";
import { loadStoredAuth, removeStoredAuth, storeAuth } from "./api";
import Layout, { RequireAuth } from "./components/Layout";
import AdoptionFormPage from "./pages/AdoptionFormPage";
import AnimalDetailPage from "./pages/AnimalDetailPage";
import AnimalsPage from "./pages/AnimalsPage";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import NotFound from "./pages/NotFound";
import RegisterPage from "./pages/RegisterPage";
import { currentRoute, navigate } from "./navigation";

export default function App() {
  const [route, setRoute] = useState(currentRoute);
  const [auth, setAuth] = useState(loadStoredAuth);

  useEffect(() => {
    const syncRoute = () => setRoute(currentRoute());
    window.addEventListener("popstate", syncRoute);
    window.addEventListener("app:navigate", syncRoute);
    return () => {
      window.removeEventListener("popstate", syncRoute);
      window.removeEventListener("app:navigate", syncRoute);
    };
  }, []);

  function handleLogin(nextAuth) {
    storeAuth(nextAuth);
    setAuth(nextAuth);
  }

  function handleLogout() {
    removeStoredAuth();
    setAuth(null);
    navigate("/");
  }

  return (
    <Layout auth={auth} onLogout={handleLogout}>
      {renderPage(route, auth, handleLogin)}
    </Layout>
  );
}

function renderPage(route, auth, handleLogin) {
  const path = route.path;

  if (path === "/") {
    return <HomePage />;
  }

  if (path === "/login") {
    return <LoginPage onLogin={handleLogin} />;
  }

  if (path === "/signin") {
    return <RegisterPage />;
  }

  if (path === "/animali") {
    return <RequireAuth auth={auth}><AnimalsPage key="all" /></RequireAuth>;
  }

  if (path === "/adozioni/visualizza") {
    return <RequireAuth auth={auth}><AnimalsPage key="available" availableOnly /></RequireAuth>;
  }

  if (path.startsWith("/animali/")) {
    return (
      <RequireAuth auth={auth}>
        <AnimalDetailPage key={path} id={path.split("/")[2]} auth={auth} />
      </RequireAuth>
    );
  }

  if (path === "/adozioni/form") {
    return (
      <RequireAuth auth={auth}>
        <AdoptionFormPage key={route.query.get("animal")} auth={auth} animalId={route.query.get("animal")} />
      </RequireAuth>
    );
  }

  return <NotFound />;
}
