package com.example.FeedBackProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {

    @Id
    private String  EmpId;

    private String emailId;

    private String name;

    private String role;

<<<<<<< HEAD
=======

>>>>>>> 5bf52053f9a31eeeaae2cec9ae3d16f8fdd5ff20
}
