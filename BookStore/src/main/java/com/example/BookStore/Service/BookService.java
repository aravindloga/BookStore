package com.example.BookStore.Service;


import com.example.BookStore.DTOS.BookDTO;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Repositery.BookRepositery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepositery bookRepositery;

    @Autowired
    ModelMapper modelMapper;



    public void saveBook(BookDTO bookDTO){

        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setCatgory(bookDTO.getCatgory());
        book.setTitle(bookDTO.getTitle());
        book.setImageUrl(bookDTO.getImageUrl());
        bookRepositery.save(book);


    }

    public String deleteBook(Long id){

        Optional<Book> findBook=bookRepositery.findById(id);
        findBook.ifPresent(book -> bookRepositery.delete(book));
        if(findBook.isPresent()){
            return "deleted";
        }
        return "Book Not found";
    }

    public void updateBook(BookDTO bookDTO){

        Book book = modelMapper.map(bookDTO,Book.class);
        bookRepositery.save(book);



    }



}
