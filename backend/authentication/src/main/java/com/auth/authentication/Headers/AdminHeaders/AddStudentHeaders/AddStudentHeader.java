package com.auth.authentication.Headers.AdminHeaders.AddStudentHeaders;

import javax.mail.Multipart;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class AddStudentHeader {
    private String studentname;
    private String fathername;
    private String mothername;
    private String mobile;
    private String enrollment;
    private String village;
    private String addmissionyear;
    private String birthdate;
    private String classname;
    private String schooltype;
    private String category;
    private String gender;
    private String midium;
    private String email;
    private String address;
    private MultipartFile file;
   
}
