package com.auth.authentication.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;


import com.auth.authentication.Entities.StudentModel.EcampusLoginSchema;


public interface AuthRepository extends JpaRepository<EcampusLoginSchema,Integer> {
   public EcampusLoginSchema findByUsername(String username);
}
