package com.auth.authentication.Entities.FeesModels;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Component
public class GeneratedFeesOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String studentname;
    private String enrollment;
    private String email;
    private String classname;
    private String Date;
    private String orderid;
    private String ammount;
}
