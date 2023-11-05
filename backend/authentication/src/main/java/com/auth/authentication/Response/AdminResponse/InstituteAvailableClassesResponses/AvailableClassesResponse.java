package com.auth.authentication.Response.AdminResponse.InstituteAvailableClassesResponses;

import java.util.List;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.StudentsModels.StudentClassCategory;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class AvailableClassesResponse {
    private Boolean NoClassesAvailable;
    private Boolean SomethingWentWrong;
    private List<StudentClassCategory> availableClasses;
}
