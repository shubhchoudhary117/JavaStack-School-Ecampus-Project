package com.auth.authentication.Response.SignupResponse;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class SignerResponse {
    private Boolean emailIsAlreadyExist;
    private String signupSuccess;
}
