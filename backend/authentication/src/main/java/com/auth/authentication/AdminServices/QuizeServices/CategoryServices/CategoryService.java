package com.auth.authentication.AdminServices.QuizeServices.CategoryServices;

import java.util.*;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.TestQuizes.Category.Categories;


public interface CategoryService {
    public Categories addCategory(Categories category);
    public Set<Categories> getCategories();
}
