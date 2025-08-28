// src/pages/HomePage.jsx
import React, { useEffect, useState } from "react";
import { getAllBooks, updateBook } from "../services/BookServices";

const HomePage = () => {
  const [books, setBooks] = useState([]);
  const [isAdmin, setIsAdmin] = useState(false); // 🔹 later fetch from auth role

  useEffect(() => {
    getAllBooks().then(setBooks).catch(console.error);
  }, []);

  const handleUpdate = async (book) => {
    // Example update: keep other fields same, only change title
    const updatedBook = {
      title: "Updated " + book.title,
      author: book.author,
      category: book.category,
      imageUrl: book.imageUrl,
    };

    try {
      const result = await updateBook(book.id, updatedBook);
      alert("Book updated!");
      setBooks((prev) => prev.map((b) => (b.id === book.id ? result : b)));
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <section className="p-6">
      <h1 className="text-2xl font-bold mb-4">Available Books</h1>
      <div className="grid grid-cols-3 gap-4">
        {books.map((book) => (
          <div key={book.id} className="p-4 border rounded shadow">
            <img
              src={book.imageUrl}
              alt={book.title}
              className="w-full h-40 object-cover mb-2 rounded"
            />
            <h2 className="font-bold">{book.title}</h2>
            <p>{book.author}</p>
            <p className="text-sm text-gray-500">Category: {book.category}</p>
            <p className="text-sm text-gray-700">₹{book.price}</p>

            {isAdmin && (
              <button
                onClick={() => handleUpdate(book)}
                className="mt-2 px-3 py-1 bg-yellow-500 text-white rounded"
              >
                Update
              </button>
            )}
          </div>
        ))}
      </div>
    </section>
  );
};

export default HomePage;
