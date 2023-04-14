package com.example.FeedBackProject.EntityDTO;

//import com.example.FeedBackProject.Entity.FeedbackRequest;
//import com.example.FeedBackProject.Entity.Questions;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Entity.Questions;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ResultDTO {

  private Long feedbackAttributeId;
  private FeedbackRequest feedbackId;
  private Questions attributeId;
  private int rating;


}
