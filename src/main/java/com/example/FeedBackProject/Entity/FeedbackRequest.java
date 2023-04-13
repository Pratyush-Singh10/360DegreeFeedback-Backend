package com.example.FeedBackProject.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="FeedbackRequest")
public class FeedbackRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FeedbackId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "emailId",name = "feedbackReceiverEmail")
    private User rEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "emailId",name = "feedbackGiverEmail")
    private User gEmail;

    @Column(nullable = true)
    private String comment;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int status;

}
