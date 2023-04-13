package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Services.FeedbackRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class FeedbackRequestController {
    @Autowired
    private FeedbackRequestService feedbackRequestService;

    @PostMapping("/feedback-requests")
    public ResponseEntity<FeedbackRequest> createFeedbackRequest(@RequestBody FeedbackRequest feedbackRequest) {
        FeedbackRequest createdFeedbackRequest = feedbackRequestService.createFeedbackRequest(feedbackRequest);
        return new ResponseEntity<>(createdFeedbackRequest, HttpStatus.CREATED);
    }

}

