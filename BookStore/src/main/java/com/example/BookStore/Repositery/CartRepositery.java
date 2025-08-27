package com.example.BookStore.Repositery;


import com.example.BookStore.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepositery extends JpaRepository<Cart,Long> {
}
