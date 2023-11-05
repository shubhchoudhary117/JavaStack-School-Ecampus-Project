package com.auth.authentication.controllers.AdminRouting.StudentsRoutings;

import java.io.File;
import java.security.Principal;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.auth.authentication.AdminServices.StudentsActionsServices.StudentServices.AdminStudentService;
import com.auth.authentication.AdminServices.StudentsActionsServices.StudentServices.AdminStudentServiceImpl;
import com.auth.authentication.Entities.AdminModel.StudentModel.StudentsSchema;
import com.auth.authentication.Entities.FeesModels.StudentFeesDetailsSchema.StudentFeesDetails;
import com.auth.authentication.Entities.StudentsModels.StudentClassCategory;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.AdminHeaders.AddStudentHeaders.AddStudentHeader;
import com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories.AddStudentRepo;
import com.auth.authentication.Repositery.AdminRepository.StudentActionsRepositories.AddNewStudentRepositories.AddStudentsClassCategoryRepo;
import com.auth.authentication.Repositery.AdminRepository.StudentsFeesRepositories.StudentFeesDetailsRepo;
import com.auth.authentication.Response.AdminResponse.StudentsActionResponses.AddStudentResponse;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/student")
public class StudentRouting {

    
    @Autowired
    AddStudentRepo addStudentRepo;

    @Autowired
    AddStudentsClassCategoryRepo studentsClassCategoryRepo;

    @Autowired
    StudentFeesDetailsRepo studentFeesDetailsRepo;

    @Autowired
    AddStudentResponse addStudentResponse;

    @Autowired
    AdminStudentServiceImpl adminStudentService;

    @GetMapping("/test")
    public String Testing() {
        return "this is test route";
    }

    @PostMapping("/addstudent")
    public ResponseEntity<?> AddNewStudent(@RequestBody StudentEcampusProfileSchema student) {

        try {

            // create student fees details object
            StudentClassCategory categoryDetails=this.studentsClassCategoryRepo.findById(student.getStudentCategory().getScid()).get();     
            StudentFeesDetails studentFeesDetails = new StudentFeesDetails();
            studentFeesDetails.setTotalfees(categoryDetails.getTotalFees());
            studentFeesDetails.setPaidfees("0");
            studentFeesDetails.setDuefees(categoryDetails.getTotalFees());

            System.out.println("Save the student fees details -------------------------------------------------");
            // save the student fees model
            StudentFeesDetails addedFeesDetails = this.studentFeesDetailsRepo.save(studentFeesDetails);
            System.out.println(addedFeesDetails.getFeesDetailsId()
                    + "--------------------------------------------------------------------");
            StudentEcampusProfileSchema temp = new StudentEcampusProfileSchema();

            // add a new  student
            student.setFeesDetails(addedFeesDetails);
            StudentEcampusProfileSchema addedStudent = this.adminStudentService.addNewStudent(student);

            if (addedStudent != null) {
                addStudentResponse.setSomethingWentWrong(false);
                addStudentResponse.setStudentAddedSuccessfully(true);
            } else {
                addStudentResponse.setSomethingWentWrong(true);
                addStudentResponse.setStudentAddedSuccessfully(false);
            }
        } catch (

        Exception e) {
            e.printStackTrace();
            addStudentResponse.setSomethingWentWrong(true);
            addStudentResponse.setStudentAddedSuccessfully(false);
        }
        return ResponseEntity.ok(this.addStudentResponse);
    }

}
