package com.auth.authentication.Response.LogerResponse;

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
public class LoginResponse {
    private Boolean usernameNotExist;
    private Boolean passwordIsNotExist;
    private String token;
    private Boolean loginSuccess;

}
