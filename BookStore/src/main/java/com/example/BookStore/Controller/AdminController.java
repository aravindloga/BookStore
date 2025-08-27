package com.example.BookStore.Controller;


import com.example.BookStore.DTOS.BookDTO;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Repositery.UserRepositery;
import com.example.BookStore.Service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    BookService bookService;

    @Autowired
    UserRepositery userRepositery;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
        return ResponseEntity.ok("Added");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted");
    }
    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/deleteuser")
    public ResponseEntity<?> deleteAlluser(){
        userRepositery.deleteAll();
        return ResponseEntity.ok("Deleted");
    }
}
