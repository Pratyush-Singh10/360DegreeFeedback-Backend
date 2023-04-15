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
import java.util.Optional;

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


//    public void saveFeedback(List<Map<String, Object>> feedback) {
//        List<Result> results = new ArrayList<>();
//        for (Map<String, Object> feedbackMap : feedback) {
//            Long feedbackId = Long.parseLong(feedbackMap.get("feedbackId").toString());
//            Long attributeId = Long.parseLong(feedbackMap.get("attributeId").toString());
//            int rating = Integer.parseInt(feedbackMap.get("rating").toString());
//
//            Result result = Result.builder()
//                    .feedbackId(feedbackId)
//                    .attributeId(new Questions(attributeId))
//                    .rating(rating)
//                    .build();
//
//            results.add(result);

        public Map<String, Object> storeResult (Long id, Map < String, Object > map) {
            Map<String, Object> response = new HashMap<>();
            FeedbackRequest feedback = this.feedbackRequestRepository.findById(id).orElseThrow();
            for (String m : map.keySet()) {
                if (m.equals("comment")) {
                    continue;
                }
                Result result = new Result();
                result.setRating((Integer) map.get(m));
                result.setFeedbackId(feedback);
                Long Qid = Long.parseLong(m);
                Questions questions = this.questionsRepository.findById(Qid).orElseThrow();
                result.setAttributeId(questions);
                feedback.setFeedbackComment((String) map.get("comment"));
                feedback.setStatus(1);
                this.feedbackRequestRepository.save(feedback);
                this.resultRepository.save(result);
                response.put("message", "Feedback Saved");
            }
            resultRepository.saveAll(results);
        }

    }

//        public Map<String, Object> storeResult (Long id, Map < String, Object > map){
//            Map<String, Object> response = new HashMap<>();
//            for (String m : map.keySet()) {
//                if (m.equals("comment")) {
//                    continue;
//                }
//                Result result = new Result();
//                result.setRating((Integer) map.get(m));
//                Questions questions = questionsRepository.findById(Long.parseLong(m)).get();
//                result.setAttributeId(questions);
//                FeedbackRequest feedbackRequest = feedbackRequestRepository.findById(id).orElse(null);
//                feedbackRequest.setFeedbackComment((String) map.get("comment"));
//                feedbackRequest.setStatus(1);
//                feedbackRequestRepository.save(feedbackRequest);
//                result.setFeedbackId(feedbackRequest);
//                resultRepository.save(result);
//                response.put("message", "Feedback Saved");
//            }
//            return response;
//        }
//    }
//
//}
