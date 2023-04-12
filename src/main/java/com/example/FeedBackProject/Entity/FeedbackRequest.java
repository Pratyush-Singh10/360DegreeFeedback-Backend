package com.example.FeedBackProject.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "emailId",name = "feedbackReceiverEmail")
    private User rEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "emailId",name = "feedbackGiverEmail")
    private User gEmail;

    private boolean status;

    private String comment;

    private int rating;
}
