package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Repository.ResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Result saveResults(Long feedbackId, Map<Long, Integer> data)
    {
            FeedbackRequest feedbackRequest = feedbackRequestRepository.findById(feedbackId)
                    .orElseThrow(() -> new EntityNotFoundException("FeedbackRequest with id " + feedbackId + " not found"));

            List<Result> results = new ArrayList<>();

            for (Map.Entry<Long, Integer> entry : data.entrySet()) {


                Questions question = questionsRepository.findById(entry.getKey())
                        .orElseThrow(() -> new EntityNotFoundException("Question with id not found"));

                Result result = Result.builder()
                        .feedbackId(feedbackRequest)
                        .attributeId(question)
                        .rating(entry.getValue())
                        .build();

                results.add(result);
            }

            return resultRepository.saveAll(results).get(0);
        }
    }


//    public Map<String, Object> storeResult(Map<String, Object> map) {
//        Map<String, Object> response = new HashMap<>();
//        for (String m : map.keySet()) {
//            if (m.equals("comment")) {
//                continue;
//            }
//            Result result = new Result();
//            result.setRating((Integer) map.get(m));
//            Questions questions = questionsRepository.findById(Long.parseLong(m)).get();
//            result.setAttributeId(questions);
//            FeedbackRequest feedbackRequest = feedbackRequestRepository.findById(); //Here we need to add Feedback Id
//            feedbackRequest.setFeedbackComment((String) map.get("comment"));
//            feedbackRequestRepository.save(feedbackRequest);
//            result.setFeedbackId(feedbackRequest);
//            resultRepository.save(result);
//            response.put("message", "Feedback Saved");
//            return response;
//        }
//    }

