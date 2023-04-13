package com.example.FeedBackProject.Entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Result {
    @Id
    private Long SNo;

    @ManyToOne
    @JoinColumn(name="FeedbackId",referencedColumnName="FeedbackId")
    private FeedbackRequest FeedbackId;

    @ManyToOne
    @JoinColumn(name="QuesId",referencedColumnName="QuesId")
    private Questions QuesId;

    private int result;
}

