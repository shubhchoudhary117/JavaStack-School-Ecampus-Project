package com.auth.authentication.Response.EcampusResponses.StudentProfileResponses;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class StudentProfileResponse {
    private Boolean AuthorizationSuccess;
    private Boolean StudetnNotPrasent;
    private StudentEcampusProfileSchema student;
}
