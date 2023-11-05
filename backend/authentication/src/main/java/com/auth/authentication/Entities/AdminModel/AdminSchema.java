package com.auth.authentication.Entities.AdminModel;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="admindata")
public class AdminSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;
    private String Name;
    private String AdminTeachingStatus;
    private String HighestQualification;
    private Long YearOfExperience;
    private String About;
    private String EmployeementType;
    private String JoiningDate;
    private String Email;
    private String Mobile;
    private String Role;
    private String EmployeeId;
}




