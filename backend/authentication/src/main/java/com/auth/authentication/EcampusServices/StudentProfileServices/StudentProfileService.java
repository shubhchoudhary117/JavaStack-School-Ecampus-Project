package com.auth.authentication.EcampusServices.StudentProfileServices;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;

public interface StudentProfileService {
    public StudentEcampusProfileSchema getStudent(String Username);
    public StudentEcampusProfileSchema updateStudent(StudentEcampusProfileSchema student);
}
