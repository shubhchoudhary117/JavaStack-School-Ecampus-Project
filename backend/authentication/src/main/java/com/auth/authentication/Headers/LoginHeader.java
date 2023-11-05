package com.auth.authentication.Headers;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginHeader {
    private String username;
    private String password;
}
