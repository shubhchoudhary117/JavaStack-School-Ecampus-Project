package com.auth.authentication.Repositery.StudentEcampusProfileRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;

public interface StudentEcampusProfileRepo extends JpaRepository<StudentEcampusProfileSchema,Integer>{
    
    public StudentEcampusProfileSchema findByEnrollment(String username);
}
