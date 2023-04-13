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

    private String rEmail;

    private String gEmail;

    @Column(nullable = true)
    private String comment;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int status;

}
