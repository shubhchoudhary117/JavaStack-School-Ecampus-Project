package com.auth.authentication.Headers;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupHeader {
    private String name;
    private String email;
    private String password;
    private String cpassword;
}
