package com.auth.authentication.Response.QuizeResponses.QuizeResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class AddQuizeResponse {
    private Boolean quizeIsAdded;
    private Boolean quizeIsDeleted;
}
