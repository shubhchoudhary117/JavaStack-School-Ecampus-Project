package com.auth.authentication.UserServices.TokenDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Headers.EmailApiHeaders.StudentDoEmailHeader;
import com.auth.authentication.Jwt.JwtUtil;
import com.auth.authentication.Repositery.StudentEcampusProfileRepositories.StudentEcampusProfileRepo;
import com.auth.authentication.Response.StudentEmailResponses.SendMailResponse;
import com.auth.authentication.UserServices.StudentMailsServices.StudentMailService;

@Service
public class GetTokenDetailsFromToken {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    SendMailResponse mailResponse; 
    @Autowired
    StudentMailService mailService;
    @Autowired
    StudentEcampusProfileRepo studentEcampusProfileRepo;

    public String getUser(String token){
        String username =null;
            try {
                username = this.jwtUtil.extractUsername(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
           
        return username;
    }
}
