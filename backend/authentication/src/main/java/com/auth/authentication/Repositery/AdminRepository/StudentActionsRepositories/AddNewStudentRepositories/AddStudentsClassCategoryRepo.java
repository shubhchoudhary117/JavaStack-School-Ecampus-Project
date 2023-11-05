package com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.StudentsModels.StudentClassCategory;

public interface AddStudentsClassCategoryRepo extends JpaRepository<StudentClassCategory,Integer>{
    
}
