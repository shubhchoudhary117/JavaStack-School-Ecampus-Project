package com.auth.authentication.controllers.TestQuizeRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.auth.authentication.AdminServices.QuizeServices.QuestionServices.*;
import com.auth.authentication.Response.QuizeResponses.QuestionResponses.QuestionResponse;
import com.auth.authentication.Entities.TestQuizes.Questions.*;
import com.auth.authentication.Headers.QuizeHeaders.QuestionHeaders.QuestionsId;
import com.auth.authentication.AdminServices.QuizeServices.QuizeServices.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionsRouting {

    @Autowired
    QuestionResponse questionResponse;
    @Autowired
    QuizeService quizeService;
    @Autowired
    QuestionServiceImpl questionService;

    @PostMapping("/addquestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        System.out.println(question);
        // add question
        Question addedQuestion=this.questionService.addQuestion(question);
        if(addedQuestion!=null){
            this.questionResponse.setQuestionIsAdded(true);
        }
        else{
            this.questionResponse.setQuestionIsAdded(false);
        }
        return ResponseEntity.ok(this.questionResponse);
    }
    
    @GetMapping("/getquestions/{id}")
    public ResponseEntity<?> getAllQuestions(@PathVariable("id")int id){
        Quize quize=new Quize();
        quize.setQid(id);
        Set<Question> allQuestions=this.questionService.getQuestionsofQuize(quize);
        System.out.println("---------------------------- qyuestions"+allQuestions);
        return ResponseEntity.ok(allQuestions);
    }

    // // create an api for testing
    // @GetMapping("/getall/{id}")
    // public ResponseEntity<?> getAll(){
    //     Quize foundedQuize=this.quizeService.getQuizeById(id);
    //     Set<Question> allQuestions=foundedQuize.getQuestions();
    //     System.out.println(allQuestions);
    //     return ResponseEntity.ok("quize");
    // }



}
