package com.auth.authentication.AdminServices.StudentsActionsServices.StudentServices;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Entities.AdminModel.StudentModel.StudentsSchema;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.AdminHeaders.AddStudentHeaders.AddStudentHeader;
import com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories.AddStudentRepo;

@Service
public class AdminStudentServiceImpl implements AdminStudentService{

    @Autowired
    AddStudentRepo addStudentRepo;

    @Override
    public StudentEcampusProfileSchema addNewStudent(StudentEcampusProfileSchema student) {
        // save the new student in database
        StudentEcampusProfileSchema addedStudent=this.addStudentRepo.save(student);
        return addedStudent;
    }
    
}
