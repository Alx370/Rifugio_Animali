export function createForm(fields, row = null) {
  return fields.reduce((acc, field) => {
    if (row) {
      acc[field.name] = field.from ? field.from(row) : row[field.name] ?? "";
    } else if (field.defaultValue !== undefined) {
      acc[field.name] = typeof field.defaultValue === "function" ? field.defaultValue() : field.defaultValue;
    } else {
      acc[field.name] = field.type === "checkbox" ? false : "";
    }
    return acc;
  }, {});
}

export function optionsForField(field, lookups) {
  if (field.options) return field.options;
  if (!field.source) return [];
  return (lookups[field.source] || []).map((row) => ({
    value: row.id,
    label: field.optionLabel ? field.optionLabel(row) : row.name || row.email || `#${row.id}`
  }));
}

export function buildPayload(fields, form) {
  return fields.reduce((payload, field) => {
    let value = form[field.name];
    if (field.type === "checkbox") {
      payload[field.name] = Boolean(value);
      return payload;
    }
    if (value === undefined || value === null || value === "") {
      return payload;
    }
    if (field.type === "number" || field.valueType === "number") {
      value = Number(value);
    }
    payload[field.name] = value;
    return payload;
  }, {});
}
