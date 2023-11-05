package com.auth.authentication.controllers.TestQuizeRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;
import com.auth.authentication.AdminServices.QuizeServices.QuizeServices.*;
import com.auth.authentication.Response.QuizeResponses.QuizeResponses.AddQuizeResponse;
import com.auth.authentication.Response.QuizeResponses.QuizeResponses.GetQuizeResponse;

@RestController
@RequestMapping("/quize")
@CrossOrigin("*")
public class QuizeRouting {

    @Autowired
    GetQuizeResponse getQuizeResponse;
  
    @Autowired
    QuizeService quizeService;

    @Autowired
    AddQuizeResponse quizeResponse;

    // add new quize
    @PostMapping("/addquize")
    public ResponseEntity<?> AddQuize(@RequestBody Quize quize){
        System.out.println("------------------------- quize"+quize);
       Quize addedQuize= this.quizeService.addQuize(quize);
       if(addedQuize!=null){this.quizeResponse.setQuizeIsAdded(true);}
       else{this.quizeResponse.setQuizeIsAdded(false);}
        return ResponseEntity.ok(this.quizeResponse);
    }

    // get all quizes
    @GetMapping("/getquizes")
    public ResponseEntity<?> getQuizes(){
        Set<Quize> quizes=this.quizeService.getQuizes();

        if(quizes.size()<=0){
            this.getQuizeResponse.setQuizes(null);
            this.getQuizeResponse.setNotAnyQuizePrasent(true);
            this.getQuizeResponse.setSomethingWentWrong(false);
            this.getQuizeResponse.setQuizeNotFound(false);
        }else{
            this.getQuizeResponse.setQuizes(quizes);
            this.getQuizeResponse.setNotAnyQuizePrasent(false);
            this.getQuizeResponse.setSomethingWentWrong(false);
            this.getQuizeResponse.setQuizeNotFound(false);
        }
        return ResponseEntity.ok(this.getQuizeResponse);
    }

    // delete quize
    @DeleteMapping("/delete-quize/{id}")
    public ResponseEntity<?> deleteQuize(@PathVariable("id")int id){
        try{
            this.quizeService.deleteQuize(id);
            this.quizeResponse.setQuizeIsDeleted(true);
        }
        catch(Exception e){
            e.printStackTrace();
            this.quizeResponse.setQuizeIsDeleted(false);
        }

        return ResponseEntity.ok(this.quizeResponse);
    }
}
