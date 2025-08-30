package com.example.BookStore.Service;


import com.example.BookStore.DTOS.LoginDTO;
import com.example.BookStore.DTOS.ResponseDTO;
import com.example.BookStore.DTOS.SignUpDTo;
import com.example.BookStore.Model.Role;
import com.example.BookStore.Model.User;
import com.example.BookStore.Repositery.UserRepositery;
import com.example.BookStore.Security.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {

    @Autowired
    UserRepositery userRepositery;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;


    public ResponseDTO SignUpService(SignUpDTo signUpDTo,HttpServletResponse response){
        User user = userRepositery.findByEmail(signUpDTo.getEmail());

            User  newUser = new User();
        if(user!=null){
            return new ResponseDTO(null);
        }
        if ("ADMIN".equalsIgnoreCase(signUpDTo.getRole())) {
            newUser.setRoles(Set.of(Role.ADMIN));
        } else {
            newUser.setRoles(Set.of(Role.USER));
        }

            newUser.setEmail(signUpDTo.getEmail());
            newUser.setFullName(signUpDTo.getFullName());
            newUser.setPassword(passwordEncoder.encode(signUpDTo.getPassword()));

            userRepositery.save(newUser);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setEmail(newUser.getEmail());
            String token =jwtUtils.generateToken(newUser.getEmail());

        ResponseCookie cookie= ResponseCookie.from("jwt",token)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(800*800)
                .sameSite("Strict")
                .build();
        response.setHeader("Set-Cokie", cookie.toString());
            return responseDTO;




}
public ResponseDTO LoginService(LoginDTO loginDTO, HttpServletResponse response){

    User user = userRepositery.findByEmail(loginDTO.getEmail());
    if(user==null){
        return new ResponseDTO(null);
    }
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            loginDTO.getEmail(),loginDTO.getPassword()
    );
    Authentication authentication = 
        authenticationManager.authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtUtils.generateToken(user.getEmail());
    ResponseCookie cookie= ResponseCookie.from("jwt",token)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(800*800)
            .sameSite("Strict")
    .build();
    response.setHeader("Set-Cookie", cookie.toString());
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setEmail(user.getEmail());

    return responseDTO;

}
}
