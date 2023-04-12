package com.example.FeedBackProject.EntityDTO;

import com.example.FeedBackProject.Entity.User;

import javax.persistence.*;
import javax.validation.constraints.Email;

public class FeedbackRequestDTO {
    private int id;

    @Email
    private User rEmail;

    @Email
    private String gEmail;

    private boolean status;

    private String comment;

    private int rating;
}
