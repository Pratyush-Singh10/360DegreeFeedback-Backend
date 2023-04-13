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
public class User {

    @Id
    private String  id;

    private String emailId;

    private String name;

    private String role;

    private int final_avg;
    private int Q1_avg;
    private int Q2_avg;
    private int Q3_avg;
    private int Q4_avg;
    private int Q5_avg;
    private int Q6_avg;

}
