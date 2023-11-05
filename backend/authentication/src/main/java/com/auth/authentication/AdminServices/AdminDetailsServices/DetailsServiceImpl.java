package com.auth.authentication.AdminServices.AdminDetailsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.AdminModel.AdminSchema;
import com.auth.authentication.Repositery.AdminRepository.AdminDetailsRepositories.*;

@Component
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    AdminDetailsRepository adminRepository;

    @Override
    public AdminSchema getAdminDetails() {
        // TODO Auto-generated method stub
        return this.adminRepository.findById(1).get();
    }
    
}
