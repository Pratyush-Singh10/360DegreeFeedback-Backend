package com.example.FeedBackProject.Services;
import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Repository.ResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
        @Autowired
        private ResultRepository resultRepository;

        @Autowired
        private FeedbackRequestRepository feedbackRequestRepository;

        @Autowired
        private QuestionsRepository questionsRepository;

        public List<Object[]> findRating(Long id) {
                List<Object[]> ratings = resultRepository.findRating(id);
                return ratings;
        }

}
