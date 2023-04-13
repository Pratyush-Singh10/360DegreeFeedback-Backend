package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class QuestionsController {
    @Autowired
    private QuestionsService Qservice;

    @GetMapping("/questions")
    public List<Questions> getQuestions(){
        return Qservice.getQuestions();
    }
    @PostMapping("/questions")
    public Questions postquestions(@RequestBody Questions ques){
        return Qservice.postQuestions(ques);
    }
}
