export function TextInput({ label, name, value, setForm, type = "text", required = false, ...props }) {
  return (
    <div className="form-group">
      <label>{label}</label>
      <input
        type={type}
        value={value}
        required={required}
        onChange={(event) => setForm((prev) => ({ ...prev, [name]: event.target.value }))}
        {...props}
      />
    </div>
  );
}

export function SelectInput({ label, name, value, setForm, options, required = false }) {
  return (
    <div className="form-group">
      <label>{label}</label>
      <select
        value={value}
        required={required}
        onChange={(event) => setForm((prev) => ({ ...prev, [name]: event.target.value }))}
      >
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
