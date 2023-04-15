package com.example.FeedBackProject.Entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackAttributeId;

    @ManyToOne
    @JoinColumn(name="feedbackId",referencedColumnName="feedbackId")
    private FeedbackRequest feedbackId;

    @ManyToOne
    @JoinColumn(name="attributeId",referencedColumnName="attributeId")
    private Questions attributeId;

    private int rating;
}

