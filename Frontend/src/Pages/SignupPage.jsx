import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { SignupService } from "../services/AuthService";

const SignupPage = () => {
  const [fullName, setFullName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSignup = async (e) => {
    e.preventDefault();
    try {
      await SignupService(fullName, email, password);
      navigate("/");
    } catch (err) {
      alert("Signup failed!");
    }
  };

  return (
    <section className="w-full h-screen flex items-center justify-center bg-gray-100">
      <div className="bg-white p-6 rounded shadow-md w-96">
        <h1 className="text-xl font-bold mb-4">Sign Up</h1>
        <form onSubmit={handleSignup} className="flex flex-col gap-3">
          <input
            type="text"
            placeholder="Full Name"
            className="border p-2 rounded"
            onChange={(e) => setFullName(e.target.value)}
          />
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
          <button className="bg-green-500 text-white py-2 rounded">Sign Up</button>
        </form>
      </div>
    </section>
  );
};

export default SignupPage;
