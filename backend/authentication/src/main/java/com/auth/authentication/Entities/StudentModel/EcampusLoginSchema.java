package com.auth.authentication.Entities.StudentModel;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@ToString
@Entity
public class EcampusLoginSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sId;
    private String username;
    private String password;


}
