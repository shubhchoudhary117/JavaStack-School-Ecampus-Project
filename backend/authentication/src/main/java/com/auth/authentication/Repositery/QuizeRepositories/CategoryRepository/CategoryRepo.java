package com.auth.authentication.Repositery.QuizeRepositories.CategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authentication.Entities.TestQuizes.Category.Categories;


public interface CategoryRepo extends JpaRepository<Categories,Integer>{
    
}
