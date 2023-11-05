package com.auth.authentication.EcampusServices.StudentProfileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Repositery.StudentEcampusProfileRepositories.StudentEcampusProfileRepo;
import java.util.*;
@Service
public class StudentProfileServiceImpl implements StudentProfileService{
    @Autowired
    StudentEcampusProfileRepo ProfileRepo;

    @Override
    public StudentEcampusProfileSchema getStudent(String Username) {
      
      StudentEcampusProfileSchema student=this.ProfileRepo.findByEnrollment(Username);
      
        return student;
    }

    @Override
    public StudentEcampusProfileSchema updateStudent(StudentEcampusProfileSchema student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }
    
}
