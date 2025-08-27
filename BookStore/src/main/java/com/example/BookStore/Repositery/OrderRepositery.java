package com.example.BookStore.Repositery;

import com.example.BookStore.Model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositery extends JpaRepository<Order,Long> {
}
