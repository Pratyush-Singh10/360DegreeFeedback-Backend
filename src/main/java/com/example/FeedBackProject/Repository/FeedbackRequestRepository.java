package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRequestRepository extends JpaRepository<FeedbackRequest, Integer> {
}
