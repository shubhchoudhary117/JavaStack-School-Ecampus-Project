package com.auth.authentication.AdminServices.StudentsActionsServices.StudentServices;

import javax.mail.Multipart;

import com.auth.authentication.Entities.AdminModel.StudentModel.StudentsSchema;
import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.auth.authentication.Headers.AdminHeaders.AddStudentHeaders.AddStudentHeader;

public interface AdminStudentService {
    public StudentEcampusProfileSchema addNewStudent(StudentEcampusProfileSchema student);
}
