package com.auth.authentication.Response.AdminNewsFeedResponses;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
public class AddNewsResponse {
    private Boolean NewsIsAdded;
    private Boolean InvalidToken;
    private Boolean SomethingWentWrong;

}
