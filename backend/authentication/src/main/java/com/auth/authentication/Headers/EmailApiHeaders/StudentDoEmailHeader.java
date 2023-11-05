package com.auth.authentication.Headers.EmailApiHeaders;

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
public class StudentDoEmailHeader {
    private String usertoken;
    private String to;
    private String subject;
    private String message;
}
