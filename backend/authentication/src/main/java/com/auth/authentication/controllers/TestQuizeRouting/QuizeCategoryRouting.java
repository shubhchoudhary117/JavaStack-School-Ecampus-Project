package com.auth.authentication.controllers.TestQuizeRouting;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.auth.authentication.Entities.TestQuizes.Category.Categories;
import com.auth.authentication.AdminServices.QuizeServices.CategoryServices.*;
import com.auth.authentication.Response.QuizeResponses.CategoryResponse.CategoryResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class QuizeCategoryRouting{
    @Autowired
    CategoryResponse categoryResponse;

    @Autowired
    CategoryService categoryService;
  
    // add new category
    @PostMapping("/addcategory")
    public ResponseEntity<?> AddCategory(@RequestBody Categories categoryData){
        System.out.println(categoryData);
        // sava the category in database
       Categories addedCategory= this.categoryService.addCategory(categoryData);
        categoryResponse.setCategoryisAdded(true);
        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/getcategories")
    public ResponseEntity<?> getAllCategories(){
        Set<Categories> categories=categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    
}