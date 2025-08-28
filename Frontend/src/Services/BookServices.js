// src/services/BookServices.js

export async function getAllBooks() {
  const response = await fetch("http://localhost:8080/public/getAll", {
    credentials: "include",
  });
  if (!response.ok) throw new Error("Failed to fetch books");

  const data = await response.json();
  // backend usually wraps in "content"
  return data.content ? data.content : data;
}

export async function updateBook(id, bookData) {
  const response = await fetch(`http://localhost:8080/admin/update/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(bookData), // must include title, author, category, imageUrl
    credentials: "include",
  });
  if (!response.ok) throw new Error("Failed to update book");
  return response.json();
}
