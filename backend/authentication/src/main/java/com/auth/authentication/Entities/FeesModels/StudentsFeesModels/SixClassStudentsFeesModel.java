package com.auth.authentication.Entities.FeesModels.StudentsFeesModels;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import com.auth.authentication.Entities.StudentsProfileModels.StudentEcampusProfileSchema;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Component
public class SixClassStudentsFeesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sfid;
    private String username;
    private String orderid;
    private String paymentid;
    private String paidfees;
    private String totalfees;
    private String duefees;
    @Temporal(TemporalType.DATE)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private StudentEcampusProfileSchema student;

}
