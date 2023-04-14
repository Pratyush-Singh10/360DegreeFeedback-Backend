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

<<<<<<< HEAD

=======
>>>>>>> d455e63d907fae97afbcec14c764af558327f266
    @PostMapping("/questions")
    public Questions postQuestions(@RequestBody Questions ques){
        return questionsService.postQuestions(ques);
    }
    @GetMapping("/questions/checkValid")
    public List<Questions> getValidQuestions(){
        return questionsService.getValidQuestions();
    }
}
