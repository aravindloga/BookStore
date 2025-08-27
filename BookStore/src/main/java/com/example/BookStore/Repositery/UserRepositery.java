package com.example.BookStore.Repositery;

import com.example.BookStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositery extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
