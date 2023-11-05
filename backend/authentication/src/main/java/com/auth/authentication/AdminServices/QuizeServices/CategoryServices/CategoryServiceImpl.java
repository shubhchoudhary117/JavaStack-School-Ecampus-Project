package com.auth.authentication.AdminServices.QuizeServices.CategoryServices;

import java.util.HashSet;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.authentication.Repositery.QuizeRepositories.CategoryRepository.CategoryRepo;
import com.auth.authentication.Entities.TestQuizes.Category.Categories;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;


@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepo categoryRepo;

    // save the category
    public Categories addCategory(Categories category){
        Categories addedCategory=categoryRepo.save(category);
        return addedCategory;
    }
    // get the caterories
    public Set<Categories> getCategories(){
        Set<Categories> categories=new HashSet<>(this.categoryRepo.findAll());
        return categories;
    }
}
