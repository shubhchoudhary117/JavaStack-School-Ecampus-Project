package com.auth.authentication.Repositery.QuizeRepositories.QuestionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.auth.authentication.Entities.TestQuizes.Questions.Question;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;

public interface QuestionRepo extends JpaRepository<Question,Integer>{
    public Set<Question> findByQuize(Quize quize);
    
}
