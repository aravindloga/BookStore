import React from "react";
import { NavLink } from "react-router-dom";
import { IoCartOutline } from "react-icons/io5";
import { CgProfile } from "react-icons/cg";

const Header = () => {
  return (
    <header className="w-full bg-gray-100 shadow-md">
      <nav className="max-w-6xl mx-auto flex justify-between items-center p-4">
        {/* Logo */}
        <NavLink to="/" className="text-xl font-bold text-blue-600">
          BookStore
        </NavLink>

        {/* Links */}
        <div className="flex gap-6 items-center">
          <NavLink
            to="/"
            className={({ isActive }) =>
              `hover:text-blue-600 ${isActive ? "text-blue-600 font-semibold" : ""}`
            }
          >
            Home
          </NavLink>

          <NavLink
            to="/cart"
            className={({ isActive }) =>
              `hover:text-blue-600 flex items-center gap-1 ${
                isActive ? "text-blue-600 font-semibold" : ""
              }`
            }
          >
            <IoCartOutline size={20} />
            Cart
          </NavLink>

          <NavLink
            to="/login"
            className={({ isActive }) =>
              `hover:text-blue-600 flex items-center gap-1 ${
                isActive ? "text-blue-600 font-semibold" : ""
              }`
            }
          >
            <CgProfile size={20} />
            Login
          </NavLink>
        </div>
      </nav>
    </header>
  );
};

export default Header;
