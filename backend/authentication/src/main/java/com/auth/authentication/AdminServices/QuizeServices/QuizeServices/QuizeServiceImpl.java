package com.auth.authentication.AdminServices.QuizeServices.QuizeServices;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.auth.authentication.Entities.TestQuizes.QuizeDetails.Quize;
import com.auth.authentication.Repositery.QuizeRepositories.QuizeRepository.*;

@Service
public class QuizeServiceImpl implements QuizeService {

    @Autowired
    QuizeRepo quizeRepo;

    // save the quize
    @Override
    public Quize addQuize(Quize quize) {
        Quize addedQize = this.quizeRepo.save(quize);
        return addedQize;
    }

    // get all quizes
    @Override
    public Set<Quize> getQuizes() {
        Set<Quize> quizes = new HashSet<>(this.quizeRepo.findAll());
        return quizes;
    }

    @Override
    public Quize getQuizeById(int quizeId) {
        Quize quize=this.quizeRepo.getQuizeById(quizeId);
        return quize;
    }

    @Override
    public void deleteQuize(int id) {
        // delete quize
      this.quizeRepo.deleteById(id);
    }



}
