package com.auth.authentication.Repositery.AdminRepository.TeachersDetailsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.auth.authentication.Entities.AdminModel.TeachersModel.TeachersDetailsSchema;

public interface TeachersDetailsRepo extends JpaRepository<TeachersDetailsSchema,Integer>{
    
    
}
