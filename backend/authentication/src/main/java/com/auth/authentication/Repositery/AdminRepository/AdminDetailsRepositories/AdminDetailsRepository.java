package com.auth.authentication.Repositery.AdminRepository.AdminDetailsRepositories;
import com.auth.authentication.Entities.AdminModel.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDetailsRepository extends JpaRepository<AdminSchema,Integer>{
    
}
