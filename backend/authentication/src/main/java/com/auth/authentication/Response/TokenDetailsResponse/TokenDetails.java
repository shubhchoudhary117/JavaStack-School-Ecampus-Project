package com.auth.authentication.Response.TokenDetailsResponse;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.Authentication.*;
import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class TokenDetails {
    private Boolean TokenValidated;
    private EcampusLoginSchema User;
    private Boolean Authentication;
    
}
