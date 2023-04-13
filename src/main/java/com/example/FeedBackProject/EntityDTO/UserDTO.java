package com.example.FeedBackProject.EntityDTO;

import javax.persistence.Id;
import javax.validation.constraints.Email;

public class UserDTO {

    private String  id;

    @Email
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
