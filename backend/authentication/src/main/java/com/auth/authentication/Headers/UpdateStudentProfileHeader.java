package com.auth.authentication.Headers;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class UpdateStudentProfileHeader {
    private String Studentname;
    private String Enrollment;
    private String Email;
    private String Mobile;
    private String Birthdate;
    private String Category;
    private String Gender;
    private String Village;
    private String Address;
}
