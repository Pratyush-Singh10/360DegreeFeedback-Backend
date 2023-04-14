package com.example.FeedBackProject.Services;
import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Repository.ResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
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
=======
import java.util.Map;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private QuestionsRepository questionsRepository;
>>>>>>> 0496deb9be98e2f59a5cf117ace39722ad477074

    public Map<Integer, Integer> storeResult(Map<Integer, Integer> map) {
        for (Integer m : map.keySet()) {
            Integer qId = m;
            Integer res = map.get(m);
            Questions ques = this.questionsRepository.findById(Long.valueOf(m)).orElseThrow();
            Result result = new Result();
            result.setQuesId(ques);
            result.setResult(res);
            this.resultRepository.save(result);
        }
        return map;
    }
}
