package com.auth.authentication.controllers.AdminRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.AdminServices.AdminDetailsServices.DetailsServiceImpl;
import com.auth.authentication.Entities.AdminModel.AdminSchema;
import com.auth.authentication.Response.AdminResponse.AdminProfileResponse.*;
@RestController
@CrossOrigin("*")
@RequestMapping("/admindetails")
public class AdminDetailsRouting {

    @Autowired
    DetailsServiceImpl detailsServices;

    @Autowired
    AdminDetailsResponse adminDetailsResponse;
    
    @GetMapping("/getdetails")
    public ResponseEntity<?> getAdminDetails(){
        AdminSchema adminDetails=this.detailsServices.getAdminDetails();
        if(adminDetails!=null){
            this.adminDetailsResponse.setAdminDetails(adminDetails);
            this.adminDetailsResponse.setAdminNotFound(false);
            System.out.println(adminDetails);
        }else{
            this.adminDetailsResponse.setAdminDetails(null);
            this.adminDetailsResponse.setAdminNotFound(true);
        }
        return ResponseEntity.ok(this.adminDetailsResponse);
    }
}
