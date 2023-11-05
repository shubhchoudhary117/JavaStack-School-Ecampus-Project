package com.auth.authentication.Security.SecurityServices;
import java.util.Collection;
import com.auth.authentication.Entities.Authentication.Authors;
import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;

@Data
@RequiredArgsConstructor
public class CoustomUserDetails implements UserDetails {

    private EcampusLoginSchema user;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
