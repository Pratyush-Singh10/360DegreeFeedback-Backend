package com.example.FeedBackProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {

    @Id
    @Column(name = "Emp_Id")
    private String id;
    private String name;
    private String emailId;
    private String role;

    public User(String empId, String name, String emailId, String role) {
        this.id = empId;
        this.name = name;
        this.emailId = emailId;
        this.role = role;
    }
}
