package com.example.FeedBackProject.EntityDTO;

import com.example.FeedBackProject.Entity.User;

import javax.persistence.*;
import javax.validation.constraints.Email;

public class FeedbackRequestDTO {
    private int FeedbackId;

    private String rEmail;

    private String gEmail;

    private int status;

    private String comment;


}
