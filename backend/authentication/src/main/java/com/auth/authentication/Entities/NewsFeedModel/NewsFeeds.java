package com.auth.authentication.Entities.NewsFeedModel;

import org.hibernate.query.sqm.CastType;
import org.w3c.dom.Text;

import com.auth.authentication.Entities.AdminModel.TeachersModel.TeachersDetailsSchema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
@ToString
public class NewsFeeds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int newsid;
    @Column(length = 100000)
    private String newscontent;
    private String newsdate;
    // relationships
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private TeachersDetailsSchema teacher;
}
