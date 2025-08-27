package com.example.BookStore.Repositery;

import com.example.BookStore.Model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositery extends JpaRepository<Book,Long> {

    Page<Book> findByCatgory(String catgroy, Pageable pageable);
    Book findByTitle(String title);
}
