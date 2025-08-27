package com.example.BookStore.DTOS;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDTo {

    private String fullName;
    private String email;
    private String password;

    private String role = "USER";
}
