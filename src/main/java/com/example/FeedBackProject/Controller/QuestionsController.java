package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class QuestionsController {
    @Autowired
    private QuestionsService Qservice;

    @GetMapping("/questions")
    public
}
