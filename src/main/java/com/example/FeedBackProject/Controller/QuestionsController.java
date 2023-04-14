package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @PostMapping("/questions")
    public Questions postQuestions(@RequestBody Questions ques){
        return questionsService.postQuestions(ques);
    }
    @GetMapping("/questions/checkValid")
    public List<Questions> getValidQuestions(){
        return questionsService.getValidQuestions();
    }

    @PutMapping("/status/{id}")
    public Questions updateStatus(@PathVariable long id, @RequestBody int val) {
        return questionsService.updateStatus(id,val);
    }
}
