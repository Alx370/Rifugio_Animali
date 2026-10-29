import { useEffect, useState } from "react";
import Layout from "./components/Layout";
import HomePage from "./pages/HomePage";
import NotFound from "./pages/NotFound";
import { currentRoute } from "./navigation";

export default function App() {
  const [route, setRoute] = useState(currentRoute);

  useEffect(() => {
    const syncRoute = () => setRoute(currentRoute());
    window.addEventListener("popstate", syncRoute);
    window.addEventListener("app:navigate", syncRoute);
    return () => {
      window.removeEventListener("popstate", syncRoute);
      window.removeEventListener("app:navigate", syncRoute);
    };
  }, []);

  return (
    <Layout>
      {route.path === "/" ? <HomePage /> : <NotFound />}
    </Layout>
  );
}
