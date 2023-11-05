package com.auth.authentication.Response.QuizeResponses.CategoryResponse;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class CategoryResponse {
    private Boolean CategoryisAdded;
}
