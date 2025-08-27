package com.example.BookStore.Controller;

import com.example.BookStore.Model.*;
import com.example.BookStore.Repositery.BookRepositery;

import com.example.BookStore.Repositery.UserRepositery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    BookRepositery bookRepositery;

    @Autowired
    UserRepositery userRepositery;


    @GetMapping("/getAll")
    public Page<Book> getAllBooks(@RequestParam(defaultValue = "0") int pageNumber,
                                  @RequestParam(defaultValue = "25") int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Book> page = bookRepositery.findAll(pageable);
        return page;


    }
    @GetMapping("/getByCatgory")
    public Page<Book> getAllCatgoryBooks(@RequestParam(defaultValue = "0") int pageNumber,
                                  @RequestParam(defaultValue = "25") int pageSize,@RequestParam(defaultValue = "Drama") String catgoy){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Book> page = bookRepositery.findByCatgory(catgoy,pageable);
        return page;


    }

//    ElasticSerach setup fails
//    @GetMapping("/getBySearch")
//    public Page<BookSearch> SearchBook(@RequestParam(defaultValue = "0") int pageNumber,
//                                 @RequestParam(defaultValue = "25") int pageSize,
//                                 @RequestParam String title,
//                                 @RequestParam String author){
//        Pageable pageable = PageRequest.of(pageNumber,pageSize);
//        Page<BookSearch> page=bookSearchRepositery.findByTitleContainingOrAuthorContaining(title,author,pageable);
//        return page;
//
//    }

    @GetMapping("/getCart")
    public List<?> getCart(@RequestParam(defaultValue = "0") int pageNumber,
                              @RequestParam(defaultValue = "25") int pageSize){

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user=userRepositery.findByEmail(email);
        if(user == null){
            return Collections.emptyList();
        }

        Cart cart = user.getCart();
        List<Order> books =cart.getOrders();
        return books;


    }

}
