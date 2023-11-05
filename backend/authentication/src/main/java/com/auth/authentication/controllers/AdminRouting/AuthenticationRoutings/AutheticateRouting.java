package com.auth.authentication.controllers.AdminRouting.AuthenticationRoutings;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.Entities.AdminModel.AuthenticationModels.AdminEcampusLoginSchema;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AutheticateRouting {
    
    @GetMapping("/testlogin")
    public String TestAuth(){
        return "authenticatio tested";
    }

    @PostMapping("/login")
    public ResponseEntity<?> adminLogEntity(@RequestBody AdminEcampusLoginSchema logerData){
        
        
        return ResponseEntity.ok("ok");
    }
}
