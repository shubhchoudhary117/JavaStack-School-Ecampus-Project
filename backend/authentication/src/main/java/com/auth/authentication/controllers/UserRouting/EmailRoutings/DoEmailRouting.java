package com.auth.authentication.controllers.UserRouting.EmailRoutings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.EmailApiHeaders.StudentDoEmailHeader;
import com.auth.authentication.Jwt.JwtUtil;
import com.auth.authentication.Repositery.StudentEcampusProfileRepositories.StudentEcampusProfileRepo;
import com.auth.authentication.Response.StudentEmailResponses.SendMailResponse;
import com.auth.authentication.UserServices.StudentMailsServices.StudentMailService;
import com.auth.authentication.UserServices.TokenDetailsService.GetTokenDetailsFromToken;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/email")
public class DoEmailRouting {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    SendMailResponse mailResponse;
    @Autowired
    StudentMailService mailService;
    @Autowired
    StudentEcampusProfileRepo studentEcampusProfileRepo;
    @Autowired
    GetTokenDetailsFromToken getTokenDetailsFromToken;
    @GetMapping("/testemail")
    public String TestRoute() {
        return "email is tested";
    }

    @PostMapping("/doemail")
    public ResponseEntity<?> SendEmail(@RequestBody StudentDoEmailHeader emailHeader) {
       String username="";
       //check the token is null or not
        if(emailHeader.getUsertoken()!=null){
            // set the response object that token is not null
            this.mailResponse.setTokenIsInvalid(false);
            // get user name from jwt token
            username=this.getTokenDetailsFromToken.getUser(emailHeader.getUsertoken());
            if(username!=null){
                this.mailResponse.setUserNotExist(false);
                // get details from db releted to this username
                StudentEcampusProfileSchema student=this.studentEcampusProfileRepo.findByEnrollment(username);
                // call the do mail service
                this.mailService.doEmail("shubhachoudhary8020@gmail.com","shubhamchoudhary8020@gmail.com","releted to fees", "pay fees before 18th april naither then pay fees with late fees ");
            }
        }else{
            this.mailResponse.setTokenIsInvalid(true);
            System.out.println("token is invalid .........................");
        }
        return ResponseEntity.ok("ok sending");
    }
}
