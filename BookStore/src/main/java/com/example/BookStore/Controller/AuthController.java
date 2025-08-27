package com.example.BookStore.Controller;


import com.example.BookStore.DTOS.LoginDTO;
import com.example.BookStore.DTOS.ResponseDTO;
import com.example.BookStore.DTOS.SignUpDTo;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repositery.UserRepositery;
import com.example.BookStore.Security.JwtUtils;
import com.example.BookStore.Service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;
;
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response){

                ResponseDTO responseDTO = authenticationService.LoginService(loginDTO,response);

                if(responseDTO.getEmail()!=null){

                    return ResponseEntity.ok(responseDTO);
                }
        return ResponseEntity.status(401).body("usernmae not found");


    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> SignUp(@RequestBody SignUpDTo signUpDTo,HttpServletResponse response){
        ResponseDTO responseDTO = authenticationService.SignUpService(signUpDTo,response);

        System.out.println(responseDTO.getEmail());
        if(responseDTO.getEmail()!=null){
            System.out.println(">>> Signup request received: " + signUpDTo.getEmail());

            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.status(400).body("usernmae  found");


    }
}
