package com.auth.authentication.Entities.TestQuizes.QuizeDetails;
import java.util.HashSet;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.TestQuizes.Questions.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.auth.authentication.Entities.TestQuizes.Category.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;
@Entity
@Data
@RequiredArgsConstructor
@ToString
@Table(name="quize")
public class Quize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qid;
    private String title;
    private String description;
    private String maxmarks;
    private String numberofquestions;
    private Boolean active;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Categories category;

    @OneToMany(mappedBy="quize",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Question> questions=new HashSet<>();
    
}
