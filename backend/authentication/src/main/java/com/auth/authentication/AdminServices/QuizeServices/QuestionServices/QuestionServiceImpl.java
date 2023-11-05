package com.auth.authentication.AdminServices.QuizeServices.QuestionServices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Entities.TestQuizes.Questions.Question;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;
import com.auth.authentication.Repositery.QuizeRepositories.QuestionRepository.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        // save the question in database
        Question addedQuestion=this.questionRepo.save(question);
        return addedQuestion;
    }

    @Override
    public Set<Question> getQuestionsofQuize(Quize quize) {
        // get all questions
       Set<Question> questions=this.questionRepo.findByQuize(quize);
       return questions;
    }
    
}
