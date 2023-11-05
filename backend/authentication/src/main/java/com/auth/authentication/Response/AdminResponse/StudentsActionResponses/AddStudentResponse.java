package com.auth.authentication.Response.AdminResponse.StudentsActionResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class AddStudentResponse {
    private Boolean studentAddedSuccessfully;
    private Boolean somethingWentWrong;
    
}
