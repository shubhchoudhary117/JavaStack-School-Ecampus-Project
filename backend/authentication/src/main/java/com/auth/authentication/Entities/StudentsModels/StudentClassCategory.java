package com.auth.authentication.Entities.StudentsModels;

import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@Component
@Entity
public class StudentClassCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scid;
    private String ClassName;
    private String TotalFees;
    private String BusFees;
    
   
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "studentCategory")
    @JsonIgnore
    private StudentEcampusProfileSchema student;
}
