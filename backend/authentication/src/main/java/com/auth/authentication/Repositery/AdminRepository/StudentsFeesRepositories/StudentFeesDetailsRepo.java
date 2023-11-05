package com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.FeesModels.StudentFeesDetailsSchema.StudentFeesDetails;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;

public interface StudentFeesDetailsRepo extends JpaRepository<StudentFeesDetails,Integer>{
    StudentFeesDetails findByStudent(StudentEcampusProfileSchema student);
}
