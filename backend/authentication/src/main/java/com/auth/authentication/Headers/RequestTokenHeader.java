package com.auth.authentication.Headers;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class RequestTokenHeader {
    private String Token;
}
