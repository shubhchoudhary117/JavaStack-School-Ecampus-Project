package com.auth.authentication.Entities.TestQuizes.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.auth.authentication.Entities.TestQuizes.QuizeDetails.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashSet;
import java.util.*;

@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name="categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String title;
    private String description;

    // mapping
    @OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quize> quizes=new LinkedHashSet<>();
    

}
