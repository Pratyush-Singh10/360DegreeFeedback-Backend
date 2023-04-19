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



    public List<Object[]> findPendingResponses(String email) {
        List<Object[]> pendingResponses = feedbackRequestRepository.findPendingResponses(email);
        return pendingResponses;
    }

    public List<Object[]> findCompletedResponses(String email) {
        List<Object[]> completedResponses = feedbackRequestRepository.findCompletedResponses(email);
        return completedResponses;
    }

    public List<Object[]> findFeedbackProviders(String email) {
        List<Object[]> feedbackProviders = feedbackRequestRepository.findFeedbackProviders(email);
        return feedbackProviders;
    }

    public String findComment(Long id) {
        String comment = feedbackRequestRepository.findComment(id);
        return comment;
    }
    public List<FeedbackRequest> getFeedbackRequestsByEmailAndStatus(String rEmail, int status) {
        return feedbackRequestRepository.findByrEmailAndStatus(rEmail, status);
    }

}
