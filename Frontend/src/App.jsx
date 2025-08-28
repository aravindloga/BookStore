import React from "react";
import { BrowserRouter as Router, Routes, Route, NavLink } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import CartPage from "./Pages/CartPage";
import LoginPage from "./Pages/LoginPage";
import SignupPage from "./Pages/SignupPage";


function App() {
  return (
    <Router>
      {/* Navbar */}
      <nav className="p-4 bg-gray-800 text-white flex justify-between">
        <div className="font-bold">📚 BookStore</div>
        <div className="flex gap-4">
          <NavLink to="/" className="hover:underline">Home</NavLink>
          <NavLink to="/cart" className="hover:underline">Cart</NavLink>
          <NavLink to="/login" className="hover:underline">Login</NavLink>
          <NavLink to="/signup" className="hover:underline">SignUp</NavLink>
        </div>
      </nav>

      {/* Routes */}
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/cart" element={<CartPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
      </Routes>
    </Router>
  );
}

export default App;
