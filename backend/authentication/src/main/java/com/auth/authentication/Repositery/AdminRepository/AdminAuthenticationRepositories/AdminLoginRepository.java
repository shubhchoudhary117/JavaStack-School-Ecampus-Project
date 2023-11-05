package com.auth.authentication.Repositery.AdminRepository.AdminAuthenticationRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.AdminModel.AuthenticationModels.AdminEcampusLoginSchema;

public interface AdminLoginRepository extends JpaRepository<AdminEcampusLoginSchema,Integer> {
    public AdminEcampusLoginSchema findByUsername(String username);
}
