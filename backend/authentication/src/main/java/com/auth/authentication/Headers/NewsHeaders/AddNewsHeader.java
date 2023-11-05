package com.auth.authentication.Headers.NewsHeaders;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class AddNewsHeader {
    private String content;
}
