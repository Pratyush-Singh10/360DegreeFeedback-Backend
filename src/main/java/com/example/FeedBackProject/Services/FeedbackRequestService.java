package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.Questions;
import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Repository.ResultRepository;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Repository.FeedbackRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    ResultRepository resultRepository;
    public List<Map<String, Object>> getFeedbackByRequesterEmailAndYear(String email, Integer year) {
        List<Map<String, Object>> feedbackList = new ArrayList<>();
        List<FeedbackRequest> feedbackRequests = feedbackRequestRepository.findByrEmail(email);
        for (FeedbackRequest feedbackRequest : feedbackRequests) {
            if (feedbackRequest.getStatus() == 1) {
                String startDateStr = feedbackRequest.getStartDate();
                String endDateStr = feedbackRequest.getEndDate();
                LocalDate startDate = LocalDate.parse(startDateStr);
                LocalDate endDate = LocalDate.parse(endDateStr);

                int startYear = startDate.getYear();
                int endYear = endDate.getYear();

                if (startYear == year || year == endYear) {
                    Map<String, Object> feedbackMap = new HashMap<>();
                    feedbackMap.put("feedbackId", feedbackRequest.getFeedbackId());
                    feedbackMap.put("projectName", feedbackRequest.getProjectName());
                    feedbackMap.put("feedbackProvider", feedbackRequest.getGEmail());
                    feedbackMap.put("selfInput", feedbackRequest.getSelfInput());
                    feedbackMap.put("startDate", startDate);
                    feedbackMap.put("endDate", endDate);
                    feedbackMap.put("feedbackComment", feedbackRequest.getFeedbackComment());
                    List<Result> results = resultRepository.findByFeedbackId(feedbackRequest);
                    for (Result result : results) {
                        Questions attribute = result.getAttributeId();
                        feedbackMap.put(attribute.getAttribute(), result.getRating());
                    }
                    feedbackList.add(feedbackMap);
                }
            }
        }
        return feedbackList;
    }


}