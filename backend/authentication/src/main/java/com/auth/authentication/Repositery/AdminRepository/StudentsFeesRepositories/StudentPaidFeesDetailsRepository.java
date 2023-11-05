package com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;
import java.util.List;


public interface StudentPaidFeesDetailsRepository extends JpaRepository<SixClassStudentsFeesModel,Integer>{
    List<SixClassStudentsFeesModel> findByUsername(String username);
}
