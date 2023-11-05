package com.auth.authentication.Entities.Authentication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="authtable")
public class Authors {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String Name;
    private String Email;
    private String Password;
}
