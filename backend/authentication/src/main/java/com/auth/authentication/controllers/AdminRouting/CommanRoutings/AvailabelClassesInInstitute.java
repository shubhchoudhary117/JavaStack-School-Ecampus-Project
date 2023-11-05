package com.auth.authentication.controllers.AdminRouting.CommanRoutings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth.authentication.Entities.StudentsModels.StudentClassCategory;
import com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories.AddStudentsClassCategoryRepo;
import com.auth.authentication.Response.AdminResponse.InstituteAvailableClassesResponses.AvailableClassesResponse;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin/institute")
public class AvailabelClassesInInstitute {

    @Autowired
    AddStudentsClassCategoryRepo classCategoryRepo;

    @Autowired
    AvailableClassesResponse classesResponse;
    
    @GetMapping("/get-availabel-class")
    public ResponseEntity<?> FetchAllAvailableClass(){
     List<StudentClassCategory> availableClasses=   this.classCategoryRepo.findAll();
    if(availableClasses.size()==0)
    {
        this.classesResponse.setAvailableClasses(null);
        this.classesResponse.setSomethingWentWrong(true);
    }else{
        this.classesResponse.setAvailableClasses(availableClasses);
        this.classesResponse.setSomethingWentWrong(false);
    }
     return ResponseEntity.ok(this.classesResponse);
    }
}
