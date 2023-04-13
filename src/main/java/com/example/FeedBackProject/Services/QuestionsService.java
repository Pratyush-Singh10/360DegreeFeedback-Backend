package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import com.example.FeedBackProject.Request.QuestionsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public List<Questions> getQuestions(){
        return questionsRepository.findAll();
    }


    public Questions postQuestions(Questions ques){
        return questionsRepository.save(ques);
    }
}
