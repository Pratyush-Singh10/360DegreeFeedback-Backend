package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.EntityDTO.ResultDTO;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
        @Autowired
        private ResultRepository resultRepository;

        @Autowired
        private FeedbackRequestRepository feedbackRequestRepository;

        @Autowired
        private QuestionsRepository questionsRepository;



}
