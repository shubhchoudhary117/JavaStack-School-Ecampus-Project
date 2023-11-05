package com.auth.authentication.Response.QuizeResponses.QuestionResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class QuestionResponse {
    private Boolean questionIsAdded;
}
