package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackRequestService {
    @Autowired
    private FeedbackRequestRepository feedbackRequestRepository;

    public FeedbackRequest createFeedbackRequest(FeedbackRequest feedbackRequest) {
        return feedbackRequestRepository.save(feedbackRequest);
    }

    public List<Object[]> findReceiverFeedbackDetails(String email) {
        List<Object[]> employeeDetails = feedbackRequestRepository.findReceiverFeedbackDetails(email);
        return employeeDetails;
    }

    public String getReceiverComments(String email) {
        String comment = feedbackRequestRepository.findReceiverComments(email);
        return comment;
    }

    public List<Object[]> findPendingResponses(String email) {
        List<Object[]> pendingResponses = feedbackRequestRepository.findPendingResponses(email);
        return pendingResponses;
    }

    public List<Object[]> findCompletedResponses(String email) {
        List<Object[]> completedResponses = feedbackRequestRepository.findCompletedResponses(email);
        return completedResponses;
    }

}
