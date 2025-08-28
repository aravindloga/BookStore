import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { LoginService } from "../services/AuthService";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      await LoginService(email, password);
      navigate("/");
    } catch (err) {
      alert("Login failed!");
    }
  };

  return (
    <section className="w-full h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-6 rounded shadow-md w-96">
        <h1 className="text-xl font-bold mb-4">Login</h1>
        <form onSubmit={handleLogin} className="flex flex-col gap-3">
          <input
            type="email"
            placeholder="Email"
            className="border p-2 rounded"
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            className="border p-2 rounded"
            onChange={(e) => setPassword(e.target.value)}
          />
          <button className="bg-blue-500 text-white py-2 rounded">Login</button>
        </form>
      </div>
    </section>
  );
};

export default LoginPage;
