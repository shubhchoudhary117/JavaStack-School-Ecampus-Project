package com.auth.authentication.Response.UserResponse.UserQuizesResponse;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;
import java.util.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class GetQuizesResponse {
    private Boolean QuizesNotFound;
    private Set<Quize> foundedQuizes;
}
