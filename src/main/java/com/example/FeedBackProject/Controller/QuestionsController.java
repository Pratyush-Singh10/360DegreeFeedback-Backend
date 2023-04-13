package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/questions")
    public List<Questions> getQuestions(){
        return questionsService.getQuestions();
    }
    @PostMapping("/questions")
    public Questions postQuestions(@RequestBody Questions ques){
        return questionsService.postQuestions(ques);
    }
}
