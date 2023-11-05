package com.auth.authentication.Entities.TestQuizes.Questions;
import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@Data
@RequiredArgsConstructor
@ToString
@Table(name="question")
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int queid;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    @ManyToOne(fetch=FetchType.EAGER)
    private Quize quize;
}