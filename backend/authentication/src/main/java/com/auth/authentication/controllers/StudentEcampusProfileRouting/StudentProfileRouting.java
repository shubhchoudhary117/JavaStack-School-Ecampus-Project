package com.auth.authentication.controllers.StudentEcampusProfileRouting;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.EcampusServices.StudentProfileServices.StudentProfileServiceImpl;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.UpdateStudentProfileHeader;
import com.auth.authentication.Jwt.JwtUtil;
import com.auth.authentication.Repositery.StudentEcampusProfileRepositories.StudentEcampusProfileRepo;
import com.auth.authentication.Response.EcampusResponses.StudentProfileResponses.StudentProfileResponse;
import com.auth.authentication.Response.StudentResponses.StudentUpdateProfileResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/revecampus/student/profile")
public class StudentProfileRouting {
    @Autowired
    StudentUpdateProfileResponse profileUpdateResponse;
    @Autowired
    StudentProfileServiceImpl profileServiceImpl;
    @Autowired
    StudentEcampusProfileRepo profileRepo;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    StudentProfileResponse profileResponse;

    @GetMapping("/getstudent/{token}")
    public ResponseEntity<?> StudentProfileDetails(@PathVariable("token") String Studenttoken) {
        
        // check the given token string is null or not
        if (Studenttoken != null) {
            try {
                // get username from stored token
                System.out.println("----------------------student ------------------------------------");
                var Username = jwtUtil.extractUsername(Studenttoken);
                // get all details from database releted this username
                StudentEcampusProfileSchema student = this.profileServiceImpl.getStudent(Username);
                // check and set the student in response object
               
                if (student != null) {
                    this.profileResponse.setStudent(student);
                    this.profileResponse.setStudetnNotPrasent(false);
                } else {
                    this.profileResponse.setStudent(null);
                    this.profileResponse.setStudetnNotPrasent(true);
                }
            } catch (UsernameNotFoundException e) {
                this.profileResponse.setStudetnNotPrasent(true);
                this.profileResponse.setStudent(null);
                e.printStackTrace();
            }

        } else {
            this.profileResponse.setAuthorizationSuccess(false);
            this.profileResponse.setStudent(null);
            this.profileResponse.setStudetnNotPrasent(true);
        }
        return ResponseEntity.ok(this.profileResponse);
    }

    // end of getstudent profile

    @PostMapping("/update")
    public ResponseEntity<?> UpdateStudentProfile(@RequestBody UpdateStudentProfileHeader updateDetails) {

        // update an student profile
        StudentEcampusProfileSchema studentProfile = this.profileRepo.findByEnrollment(updateDetails.getEnrollment());
        
      
        studentProfile.setEmail(updateDetails.getEmail());
        studentProfile.setMobile(updateDetails.getMobile());
        studentProfile.setGender(updateDetails.getGender());
        studentProfile.setCategory(updateDetails.getCategory());
        studentProfile.setVillage(updateDetails.getVillage());
        studentProfile.setBirthdate(updateDetails.getBirthdate());
        studentProfile.setAddress(updateDetails.getAddress());

        // update the user profile
        StudentEcampusProfileSchema updatedStudent=this.profileRepo.save(studentProfile);

        // check the profile updated or not 
        if(updatedStudent!=null){
            this.profileUpdateResponse.setUpdateSuccessfully(true);
            this.profileUpdateResponse.setSomethingWentwrong(false);
        }else{
            this.profileUpdateResponse.setUpdateSuccessfully(false);
            this.profileUpdateResponse.setSomethingWentwrong(true);
        }

        return ResponseEntity.ok(this.profileUpdateResponse);

    }

}
