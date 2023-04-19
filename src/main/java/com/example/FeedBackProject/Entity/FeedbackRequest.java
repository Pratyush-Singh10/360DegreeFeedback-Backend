package com.example.FeedBackProject.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="FeedbackRequest")
public class FeedbackRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;

@Column(name="feedbackRequester")
    private String rEmail;
    private String selfInput;

@Column(name="feedbackProvider")
    private String gEmail;

    @Column(nullable = true)
    private String feedbackComment;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int status;

    private String startDate;

    private String endDate;

    private String projectName;


}
