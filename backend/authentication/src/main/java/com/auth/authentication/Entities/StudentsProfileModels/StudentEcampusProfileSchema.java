package com.auth.authentication.Entities.StudentsProfileModels;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.FeesModels.StudentFeesDetailsSchema.StudentFeesDetails;
import com.auth.authentication.Entities.FeesModels.StudentsFeesModels.SixClassStudentsFeesModel;
import com.auth.authentication.Entities.StudentsModels.StudentClassCategory;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="studentprofile")
public class StudentEcampusProfileSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int spId;
    private String Studentname;
    private String Fathername;
    private String Mothername;
    private String enrollment;
    private String Email;
    private String Mobile;
    private String Gender;
    private String Category;
    private String Classname;
    private String Village;
    private String Pincode;
    private String Address; 
    private String birthdate;
    private String Addmissionyear;
    private String Schooltype;
    private String Midium;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Set<SixClassStudentsFeesModel> feesModels;

    @OneToOne(fetch = FetchType.EAGER)
    private StudentClassCategory studentCategory;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private StudentFeesDetails feesDetails;
   
}
