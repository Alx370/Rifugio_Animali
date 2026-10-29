import { useEffect, useMemo, useState } from "react";
import { apiPage, apiRequest } from "../../api";
import Alert from "../../components/Alert";
import Loading from "../../components/Loading";
import { lookupPaths } from "../../constants";
import { pageContent, valueOrDash } from "../../utils/formatters";
import { buildPayload, createForm, optionsForField } from "./adminFormUtils";
import { entityConfigs } from "./entityConfigs";

export default function AdminEntityPage({ entityKey }) {
  const config = entityConfigs[entityKey];
  const [rows, setRows] = useState([]);
  const [lookups, setLookups] = useState({});
  const [form, setForm] = useState(() => createForm(config.fields));
  const [editing, setEditing] = useState(null);
  const [loading, setLoading] = useState(true);
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  const [reloadKey, setReloadKey] = useState(0);

  const sources = useMemo(
    () => [...new Set(config.fields.map((field) => field.source).filter(Boolean))],
    [config.fields]
  );

  useEffect(() => {
    let cancelled = false;
    Promise.all([
      apiPage(config.path, { size: 300 }),
      ...sources.map((source) => apiPage(lookupPaths[source], { size: 500 }).then((page) => [source, pageContent(page)]))
    ])
      .then(([page, ...lookupEntries]) => {
        if (cancelled) return;
        setRows(pageContent(page));
        setLookups(Object.fromEntries(lookupEntries));
      })
      .catch((err) => {
        if (!cancelled) setError(err.message);
      })
      .finally(() => {
        if (!cancelled) setLoading(false);
      });

    return () => {
      cancelled = true;
    };
  }, [config.path, reloadKey, sources]);

  function resetForm() {
    setEditing(null);
    setForm(createForm(config.fields));
  }

  function editRow(row) {
    setEditing(row);
    setForm(createForm(config.fields, row));
    window.scrollTo({ top: 0, behavior: "smooth" });
  }

  async function deleteRow(row) {
    if (!window.confirm("Eliminare questo record?")) return;
    setError("");
    setMessage("");
    try {
      await apiRequest(`${config.path}/${row.id}`, { method: "DELETE" });
      setMessage("Record eliminato.");
      setLoading(true);
      setReloadKey((key) => key + 1);
    } catch (err) {
      setError(err.message);
    }
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setError("");
    setMessage("");
    try {
      const payload = buildPayload(config.fields, form);
      await apiRequest(`${config.path}${editing ? `/${editing.id}` : ""}`, {
        method: editing ? "PATCH" : "POST",
        body: payload
      });
      setMessage(editing ? "Record aggiornato." : "Record creato.");
      resetForm();
      setLoading(true);
      setReloadKey((key) => key + 1);
    } catch (err) {
      setError(err.message);
    }
  }

  return (
    <main className="animals-section admin-section">
      <div className="section-title">{config.title.toUpperCase()}</div>
      <section className="admin-form-panel">
        <h2>{editing ? "Modifica" : "Aggiungi"}</h2>
        <Alert type="success">{message}</Alert>
        <Alert type="error">{error}</Alert>
        <form onSubmit={handleSubmit}>
          <div className="form-grid">
            {config.fields.map((field) => (
              <AdminField
                key={field.name}
                field={field}
                value={form[field.name]}
                editing={Boolean(editing)}
                setForm={setForm}
                options={optionsForField(field, lookups)}
              />
            ))}
          </div>
          <div className="button-row">
            <button type="submit" className="btn-primary">
              {editing ? "Salva modifiche" : "Aggiungi"}
            </button>
            {editing && (
              <button type="button" className="filter-btn secondary-btn" onClick={resetForm}>
                Annulla
              </button>
            )}
          </div>
        </form>
      </section>

      <section className="animals-table-container admin-table">
        {loading ? (
          <Loading />
        ) : rows.length === 0 ? (
          <div className="no-results visible">Nessun record disponibile.</div>
        ) : (
          <table>
            <thead>
              <tr>
                {config.columns.map((column) => (
                  <th className="header-btn" key={column.header}>
                    {column.header}
                  </th>
                ))}
                <th className="header-btn">Azioni</th>
              </tr>
            </thead>
            <tbody>
              {rows.map((row) => (
                <tr className="table-row" key={row.id}>
                  {config.columns.map((column) => (
                    <td data-label={column.header} key={column.header}>
                      {valueOrDash(column.render(row))}
                    </td>
                  ))}
                  <td data-label="Azioni" className="action-cell">
                    <button type="button" className="update-animal-btn" onClick={() => editRow(row)}>
                      Modifica
                    </button>
                    <button type="button" className="delete-animal-btn" onClick={() => deleteRow(row)}>
                      Elimina
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </section>
    </main>
  );
}

function AdminField({ field, value, setForm, options, editing }) {
  const required = field.required || (!editing && field.requiredOnCreate);

  function update(value) {
    setForm((prev) => ({ ...prev, [field.name]: value }));
  }

  if (field.type === "checkbox") {
    return (
      <label className="checkbox-field">
        <input type="checkbox" checked={Boolean(value)} onChange={(event) => update(event.target.checked)} />
        {field.label}
      </label>
    );
  }

  if (field.type === "select") {
    return (
      <div className="form-group">
        <label>{field.label}</label>
        <select value={value ?? ""} required={required} onChange={(event) => update(event.target.value)}>
          <option value="">Seleziona</option>
          {options.map((option) => (
            <option key={option.value} value={option.value}>
              {option.label}
            </option>
          ))}
        </select>
      </div>
    );
  }

  if (field.type === "textarea") {
    return (
      <div className="form-group full-span">
        <label>{field.label}</label>
        <textarea value={value ?? ""} required={required} onChange={(event) => update(event.target.value)} />
      </div>
    );
  }

  return (
    <div className="form-group">
      <label>{field.label}</label>
      <input
        type={field.type || "text"}
        value={value ?? ""}
        required={required}
        min={field.min}
        step={field.step}
        onChange={(event) => update(event.target.value)}
      />
    </div>
  );
}
