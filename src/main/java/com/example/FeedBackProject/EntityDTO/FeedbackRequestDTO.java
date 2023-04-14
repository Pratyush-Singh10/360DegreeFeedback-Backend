package com.example.FeedBackProject.EntityDTO;

import com.example.FeedBackProject.Entity.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

public class FeedbackRequestDTO {
    private int feedbackId;

    private String rEmail;
    private String selfInput;

    private String gEmail;
    private String feedbackComment;

    private int status;

   private LocalDate startDate;
    private LocalDate endDate;


}
