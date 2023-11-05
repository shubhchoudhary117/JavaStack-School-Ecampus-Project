package com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.AdminModel.StudentModel.StudentsSchema;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;

public interface AddStudentRepo extends JpaRepository<StudentEcampusProfileSchema,Integer>{
    public StudentEcampusProfileSchema findByEnrollment(String username);
}
