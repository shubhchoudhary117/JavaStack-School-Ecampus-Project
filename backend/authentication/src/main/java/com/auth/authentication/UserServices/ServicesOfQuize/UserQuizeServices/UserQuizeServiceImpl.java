package com.auth.authentication.UserServices.ServicesOfQuize.UserQuizeServices;

import java.util.Set;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authentication.Repositery.QuizeRepositories.QuizeRepository.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;
import com.auth.authentication.Entities.TestQuizes.Category.*;

@Service
public class UserQuizeServiceImpl implements UserQuizeService{

    @Autowired
    QuizeRepo quizeRepository;

    @Override
    public Set<Quize> getActiveQuizes() {
        Set<Quize> activeQuizes=this.quizeRepository.findByActive(true);
        return activeQuizes;
    }

    @Override
    public Set<Quize> getQuizByCategory(Categories category) {
        // TODO Auto-generated method stub
       Set<Quize>quizes= this.quizeRepository.findByCategory(category);
        return quizes;
    }

    @Override
    public Set<Quize> getQuizeByActiveAndCategory(Categories category) {
        // TODO Auto-generated method stub
        Set<Quize> activewithCategoryQuizes=this.quizeRepository.findByCategoryAndActive(category, true);
        return activewithCategoryQuizes;
    }

    @Override
    public Set<Quize> getAllQuizes() {
        Set<Quize> allQuizes=new HashSet(this.quizeRepository.findAll());
        return allQuizes;
    }
    
}
