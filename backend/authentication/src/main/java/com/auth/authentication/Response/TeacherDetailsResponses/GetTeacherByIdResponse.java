package com.auth.authentication.Response.TeacherDetailsResponses;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.AdminModel.TeachersModel.TeachersDetailsSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class GetTeacherByIdResponse {
    private Boolean teacherIdInvalid;
    private Boolean TeacherNotPrasent;
    private Boolean Somethingwentwrong;
    private TeachersDetailsSchema teacherDetails;
}
