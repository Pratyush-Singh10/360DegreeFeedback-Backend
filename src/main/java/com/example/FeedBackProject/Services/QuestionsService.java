package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    public Questions postQuestions(Questions ques){
        return questionsRepository.save(ques);
    }

    public List<Questions> getValidQuestions(){
        return questionsRepository.find();
    }

    public Questions updateStatus(long id, int val) {
        Questions newQue = questionsRepository.findById(id).orElse(null);
        newQue.setStatus(val);
        questionsRepository.save(newQue);
        return newQue;
    }

}
