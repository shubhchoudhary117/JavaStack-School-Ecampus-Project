package com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.FeesModels.GeneratedFeesOrders;

public interface GeneratedFeesOrderRepository extends JpaRepository<GeneratedFeesOrders,Integer> {
    
}
