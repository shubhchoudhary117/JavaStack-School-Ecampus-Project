package com.auth.authentication.Entities.AdminModel.StudentModel;

import javax.mail.Multipart;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Component
public class StudentsSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sId;
    private String studentname;
    private String fathername;
    private String mothername;
    private String mobile;
    private String enrollment;
    private String village;
    private String addmissionyear;
    private String birthdate;
    private String classname;
    private String schooltype;
    private String category;
    private String gender;
    private String midium;
    private String email;
    private String address;
    @Lob
    private byte[] image;


}
