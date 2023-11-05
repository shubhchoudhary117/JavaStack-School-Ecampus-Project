package com.auth.authentication.controllers.UserRouting.TeachersDetailsRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.Entities.AdminModel.TeachersModel.TeachersDetailsSchema;
import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;
import com.auth.authentication.Repositery.AdminRepository.TeachersDetailsRepository.TeachersDetailsRepo;
import com.auth.authentication.Response.TeacherDetailsResponses.GetTeacherByIdResponse;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/teachers")
public class TeachersDetailsRoutes {

    @Autowired
    TeachersDetailsRepo teachersDetailsRepo;

    @Autowired
    GetTeacherByIdResponse getTeacherByIdResponse;

    // get all teacher details
    @GetMapping("/teacherdetails")
    public ResponseEntity<?> getAllTeachers() {
        List<TeachersDetailsSchema> teachers = this.teachersDetailsRepo.findAll();
        return ResponseEntity.ok(teachers);
    }

    // get specific teacher detail
    @GetMapping("/teacherbyname/{name}")
    public ResponseEntity<?> getTeacherByTeacherName(@PathVariable("name") String name) {

        return ResponseEntity.ok("ok also fine");
    }

    // get specific teacher detail
    @GetMapping("/teacherbyid/{tid}")
    public ResponseEntity<?> getTeacherByTeacherId(@PathVariable("tid") int tid) {

        TeachersDetailsSchema teacher = null;
        try {
            // get the teacher by id
            teacher = this.teachersDetailsRepo.findById(tid).get();
            // set the response object
            if (teacher != null) {
                this.getTeacherByIdResponse.setSomethingwentwrong(false);
                this.getTeacherByIdResponse.setTeacherIdInvalid(false);
                this.getTeacherByIdResponse.setTeacherNotPrasent(false);
                this.getTeacherByIdResponse.setTeacherDetails(teacher);
            } else {
                this.getTeacherByIdResponse.setSomethingwentwrong(false);
                this.getTeacherByIdResponse.setTeacherIdInvalid(false);
                this.getTeacherByIdResponse.setTeacherNotPrasent(true);
                this.getTeacherByIdResponse.setTeacherDetails(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
            this.getTeacherByIdResponse.setSomethingwentwrong(true);
            this.getTeacherByIdResponse.setTeacherIdInvalid(true);
            this.getTeacherByIdResponse.setTeacherNotPrasent(false);
            this.getTeacherByIdResponse.setTeacherDetails(null);
        }

        return ResponseEntity.ok(this.getTeacherByIdResponse);
    }
}
