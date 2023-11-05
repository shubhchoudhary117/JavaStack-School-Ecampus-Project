package com.auth.authentication.Entities.FeesModels.StudentFeesDetailsSchema;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentFeesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feesDetailsId;
    private String totalfees;
    private String duefees;
    private String paidfees;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "feesDetails")
    @JsonIgnore
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private StudentEcampusProfileSchema student;
}
