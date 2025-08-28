import React, { useState } from "react";

const CartPage = () => {
  const [cart, setCart] = useState([
    { id: 1, title: "Book A", price: 200 },
    { id: 2, title: "Book B", price: 300 },
  ]);

  const total = cart.reduce((sum, item) => sum + item.price, 0);

  return (
    <section className="p-6">
      <h1 className="text-2xl font-bold mb-4">Your Cart</h1>
      {cart.length === 0 ? (
        <p>No items in cart.</p>
      ) : (
        <div>
          {cart.map((item) => (
            <div key={item.id} className="flex justify-between p-2 border-b">
              <span>{item.title}</span>
              <span>₹{item.price}</span>
            </div>
          ))}
          <h2 className="mt-4 font-bold">Total: ₹{total}</h2>
        </div>
      )}
    </section>
  );
};

export default CartPage;
