package com.auth.authentication.controllers.UserRouting.QuizeRoutes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.Entities.TestQuizes.Category.Categories;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
import com.auth.authentication.Response.UserResponse.UserQuizesResponse.GetQuizesResponse;
import com.auth.authentication.UserServices.ServicesOfQuize.UserQuizeServices.UserQuizeServiceImpl;

import java.util.*;
@RestController
@RequestMapping("/user/quizes")
@CrossOrigin("*")
public class UserQuizeRouting {
    @Autowired
    GetQuizesResponse getQuizesResponse;

    @Autowired
    UserQuizeServiceImpl quizeService;

    // get all quizes
    @GetMapping("/getall-quizes")
    public ResponseEntity<?> getAllQuizes(){
        // get all quizes
        Set<Quize> allQuizes=this.quizeService.getAllQuizes();
        return ResponseEntity.ok(allQuizes);
    }

    // get quizes by category
    @GetMapping("/getquizes-by-category/{id}")
    public ResponseEntity<?> getQuizesByCategory(@PathVariable("id")int id){
        // set the category id
        Categories category=new Categories();
        category.setCid(id);
        // get quizes by category
        Set<Quize> quizes=this.quizeService.getQuizByCategory(category);
        if(quizes!=null){
            this.getQuizesResponse.setFoundedQuizes(quizes);
            this.getQuizesResponse.setQuizesNotFound(true);
        }else{
            this.getQuizesResponse.setFoundedQuizes(null);
            this.getQuizesResponse.setQuizesNotFound(true);
        }
        return ResponseEntity.ok(this.getQuizesResponse);
    }

    // get active quizes
    @GetMapping("/get-active-quizes")
    public ResponseEntity<?> getActiveQuizes(){
        // get all active quizes
        Set<Quize> activeQuizes=this.quizeService.getActiveQuizes();
        if(activeQuizes!=null){
            this.getQuizesResponse.setFoundedQuizes(activeQuizes);
            this.getQuizesResponse.setQuizesNotFound(false);
        }
        else{
            this.getQuizesResponse.setFoundedQuizes(null);
            this.getQuizesResponse.setQuizesNotFound(true);
        }
        return ResponseEntity.ok(this.getQuizesResponse);
    }

    // get active quizes of particular category
    @GetMapping("/get-active-quizesby-category/{id}")
    public ResponseEntity<?> getActiveQuizesWithCategory(@PathVariable("id")int id){
        Categories category=new Categories();
        category.setCid(id);
        Set<Quize> quizes=this.quizeService.getQuizeByActiveAndCategory(category);
        if(quizes!=null){
            this.getQuizesResponse.setFoundedQuizes(quizes);
            this.getQuizesResponse.setQuizesNotFound(false);
        }else{
            this.getQuizesResponse.setFoundedQuizes(null);
            this.getQuizesResponse.setQuizesNotFound(true);
        }
        return ResponseEntity.ok(this.getQuizesResponse);
    }
}
