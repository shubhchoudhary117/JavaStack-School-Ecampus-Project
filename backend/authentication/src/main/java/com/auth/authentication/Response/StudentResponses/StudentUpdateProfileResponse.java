package com.auth.authentication.Response.StudentResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class StudentUpdateProfileResponse {
    private Boolean UpdateSuccessfully;
    private Boolean SomethingWentwrong;
}
