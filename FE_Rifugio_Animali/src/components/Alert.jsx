export default function Alert({ children, type = "info" }) {
  if (!children) return null;
  return <div className={`alert alert-${type}`}>{children}</div>;
}
