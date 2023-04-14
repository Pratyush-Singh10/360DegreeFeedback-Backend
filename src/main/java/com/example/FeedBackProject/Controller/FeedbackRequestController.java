package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Services.FeedbackRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/ReceiverDetails/{email}")
    public List<Object[]> findReceiverFeedbackDetails(@PathVariable String email) {
        return feedbackRequestService.findReceiverFeedbackDetails(email);
    }

    @GetMapping("/getComments")
    public String getComments(@RequestBody String email) {
        return feedbackRequestService.getReceiverComments(email);
    }

}

