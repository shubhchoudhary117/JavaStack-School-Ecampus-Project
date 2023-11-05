package com.auth.authentication.AdminServices.QuizeServices.QuestionServices;
import org.springframework.stereotype.Service;
import com.auth.authentication.Entities.TestQuizes.Questions.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;

import java.util.*;
@Service
public interface QuestionService {
    public Question addQuestion(Question question);
    public Set<Question> getQuestionsofQuize(Quize quize);
}
