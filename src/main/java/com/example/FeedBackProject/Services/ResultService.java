package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Repository.ResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private QuestionsRepository questionsRepository;
    public Map<Integer,Integer> storeResult(Map<Integer,Integer> map) {
        for(Integer m:map.keySet()){
            Integer qId=m;
            Integer res=map.get(m);
            Questions ques=this.questionsRepository.findById(Long.valueOf(m)).orElseThrow();
            Result result=new Result();
            result.setQuesId(ques);
            result.setResult(res);
            this.resultRepository.save(result);

        }

    return map;
    }
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
