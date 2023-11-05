package com.auth.authentication.controllers;

import com.auth.authentication.Jwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth.authentication.Entities.Authentication.*;
import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;
import com.auth.authentication.Headers.LoginHeader;
import com.auth.authentication.Headers.SignupHeader;
import com.auth.authentication.Headers.RequestTokenHeader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.auth.authentication.Repositery.AuthRepository;
import com.auth.authentication.Response.SignupResponse.SignerResponse;
import com.auth.authentication.Response.TokenDetailsResponse.TokenDetails;
import com.auth.authentication.Response.LogerResponse.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import com.auth.authentication.Security.SecurityServices.CoustomUserDetailsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/revecampus/student")
public class Routing {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenDetails tokenDetails;
    @Autowired
    AuthRepository authRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CoustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    SignerResponse signerResponse;

    @Autowired
    LoginResponse loginResponse;

    // this mapping for testing the api
    @GetMapping("/dashboard")
    public String TestApi() {
        return "<h1 style='font-size:3rem;text-transform:capitalize;color:pink;text-align:center;'>wellcome to akki's House </h1>";
    }

    
    // login the user and provid the jwt token
    @PostMapping("/login")
    public ResponseEntity<?> UserLogin(@RequestBody LoginHeader loger)throws Exception {
        EcampusLoginSchema logerExist = this.authRepository.findByUsername(loger.getUsername());
        System.out.println(logerExist);
        if (logerExist != null) {
            loginResponse.setUsernameNotExist(false);
            // decode the password
            Boolean passwordIsMatching = this.passwordEncoder.matches(loger.getPassword(), logerExist.getPassword());
            if (passwordIsMatching) {
                System.out.println("--------------------------loged");
                // ---------------- generate jwt token and send jwt token -----------------
                // declare the variable token for stor the token
                String token = null;
                try {
                    this.authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(loger.getUsername(), loger.getPassword()));
                    // if the user is authenticated
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(loger.getUsername());
                    token = this.jwtUtil.generateToken(userDetails);
                } catch (UsernameNotFoundException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    throw new Exception("bad details");
                }

                // if token is generated then set the jwt response
                if (token != null) {
                    this.loginResponse.setToken(token);
                } else {
                    this.loginResponse.setToken(null);
                }

                // ----------------- jwt token ---------------------------------------------
                loginResponse.setUsernameNotExist(false);
                loginResponse.setLoginSuccess(true);
                loginResponse.setPasswordIsNotExist(false);
            } else {
                loginResponse.setPasswordIsNotExist(true);
            }
        } else {
            loginResponse.setUsernameNotExist(true);
            loginResponse.setPasswordIsNotExist(false);
            loginResponse.setLoginSuccess(false);
            loginResponse.setToken(null);
        }
        return ResponseEntity.ok(this.loginResponse);
    }

    //coustom checking and extract user details from sended jwt token
    @PostMapping("/authenticate")
    public ResponseEntity<?> JwtUnsined(@RequestBody RequestTokenHeader requestToken){
        System.out.println("--------------------- "+requestToken);
        String username=null;
        // get details from token 
        if(requestToken.getToken()!=null){
        try{
            username=this.jwtUtil.extractUsername(requestToken.getToken());
        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
            this.tokenDetails.setAuthentication(true);
            this.tokenDetails.setTokenValidated(true);
            this.tokenDetails.setUser(null);
        }
        if(username!=null){
            try{
             EcampusLoginSchema user=this.authRepository.findByUsername(username);
            //  check the user if founded or not
             if(user!=null){
                this.tokenDetails.setAuthentication(true);
                this.tokenDetails.setTokenValidated(true);
                this.tokenDetails.setUser(user);
             }
             else{
                this.tokenDetails.setAuthentication(false);
                this.tokenDetails.setTokenValidated(false);
                this.tokenDetails.setUser(null);
             }
            }
            catch(UsernameNotFoundException e){
                e.printStackTrace();
            }
            // check user is founded or not
        }
        else{
            // if username is not found so token is invalid and uaser is not authenticated
            this.tokenDetails.setAuthentication(false);
            this.tokenDetails.setTokenValidated(false);
            this.tokenDetails.setUser(null);
        }
        return ResponseEntity.ok(this.tokenDetails);
    }

    // // generate token testing
    // @PostMapping("/auth")
    // public ResponseEntity<?> GenerateToken(@RequestBody LoginHeader jwtRequest) throws Exception {
    //     // declare the variable token for stor the token
    //     String token = null;
    //     try {
    //         this.authenticationManager.authenticate(
    //                 new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
    //         // if the user is authenticated
    //         UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getEmail());
    //         token = this.jwtUtil.generateToken(userDetails);
    //     } catch (UsernameNotFoundException e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //         throw new Exception("bad details");
    //     }

    //     // if token is generated then set the jwt response
    //     if (token != null) {
    //         this.loginResponse.setToken(token);
    //     } else {
    //         this.loginResponse.setToken(null);
    //     }

    //     return ResponseEntity.ok(loginResponse);
    // }

}
