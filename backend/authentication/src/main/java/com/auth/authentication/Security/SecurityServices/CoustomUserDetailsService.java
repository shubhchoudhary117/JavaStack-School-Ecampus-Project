package com.auth.authentication.Security.SecurityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.*;
import com.auth.authentication.Entities.Authentication.*;
import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;
import com.auth.authentication.Repositery.AuthRepository;
import com.auth.authentication.Security.SecurityServices.CoustomUserDetails;
import java.util.*;

@Component
public class CoustomUserDetailsService implements UserDetailsService {
    @Autowired
     AuthRepository repositery;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // fetch the user from repositery
        EcampusLoginSchema user=this.repositery.findByUsername(username);
        CoustomUserDetails userDetails;
        if(user!=null){
            userDetails=new CoustomUserDetails();
            userDetails.setUser(user);
        
        }
        else{
            throw new UsernameNotFoundException("usrname is not found"+username);
        }
        return userDetails;
      
    }
    
}
