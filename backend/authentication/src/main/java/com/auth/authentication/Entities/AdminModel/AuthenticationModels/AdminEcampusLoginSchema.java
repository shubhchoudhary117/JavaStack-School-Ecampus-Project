package com.auth.authentication.Entities.AdminModel.AuthenticationModels;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Component
@Data
@RequiredArgsConstructor
@ToString
public class AdminEcampusLoginSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminid;
    private String username;
    private String password;
}
