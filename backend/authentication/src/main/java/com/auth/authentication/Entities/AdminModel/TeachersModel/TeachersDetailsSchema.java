package com.auth.authentication.Entities.AdminModel.TeachersModel;

import org.hibernate.query.sqm.CastType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authentication.Entities.NewsFeedModel.NewsFeeds;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.*;
@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="TeachersDetailsTable")
public class TeachersDetailsSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tid;
    private String TeacherName;
    private String TeacherTeachingSubject;
    private String TeacherEnrollment;
    private String TeacherRole;
    private String TeacherEmail;
    private String TeacherMobile;
    private String AboutTeacher;
    private String TeacherPhoto;
    private String TeacherExperience;
    private String TeacherJoiningDate;
    private String TeacherJobType;
    private String TeacherQualifications;
    private String TeacherStatus;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "teacher")
    private Set<NewsFeeds> newses;
}
