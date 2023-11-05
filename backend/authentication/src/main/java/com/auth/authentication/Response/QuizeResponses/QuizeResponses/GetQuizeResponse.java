package com.auth.authentication.Response.QuizeResponses.QuizeResponses;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.util.*;
@Component
@Data
@RequiredArgsConstructor
@ToString
public class GetQuizeResponse {
    private Boolean QuizeNotFound;
    private Boolean NotAnyQuizePrasent;
    private Boolean SomethingWentWrong;
    private Set<Quize> quizes;
}
