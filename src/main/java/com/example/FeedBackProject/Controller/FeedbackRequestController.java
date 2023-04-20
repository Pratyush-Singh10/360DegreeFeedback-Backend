package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Services.FeedbackRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
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


    @GetMapping("/pendingResponses/{email}")
    public List<Object[]> findPendingResponses(@PathVariable String email) {
        return feedbackRequestService.findPendingResponses(email);
    }

    @GetMapping("/completedResponses/{email}")
    public List<Object[]> findCompletedResponses(@PathVariable String email) {
        return feedbackRequestService.findCompletedResponses(email);
    }

    @GetMapping("/feedbackProviders/{email}")
    public List<Object[]> findFeedbackProviders(@PathVariable String email) {
        return feedbackRequestService.findFeedbackProviders(email);
    }

    @GetMapping("/findComment/{id}")
    public String findComment(@PathVariable Long id) {

        return feedbackRequestService.findComment(id);
    }

    @GetMapping
    public List<FeedbackRequest> getFeedbackRequestsByEmailAndStatus(
            @RequestParam(name = "rEmail") String rEmail,
            @RequestParam(name = "status") int status) {
        return feedbackRequestService.getFeedbackRequestsByEmailAndStatus(rEmail, status);
    }

    @GetMapping("/getResult/{email}")
    public List<Object[]> getResult(@PathVariable String email) {
        return feedbackRequestService.getResult(email);
    }
}
