export async function LoginService(email, password) {
  const response = await fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
    credentials: "include"
  });
  if (!response.ok) throw new Error("Login Failed");
  return response.json();
}

export async function SignupService(fullName, email, password) {
  const response = await fetch("http://localhost:8080/auth/signup", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ fullName, email, password }),
    credentials: "include"
  });
  if (!response.ok) throw new Error("Signup Failed");
  return response.json();
}
