package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRequestRepository extends JpaRepository<FeedbackRequest, Integer> {

    @Query(value = "select fr.r_email,e.name,e.emp_id from feedback_request fr, user e "+
            "where fr.status=0 and fr.g_email=:email and fr.r_email=e.email_id", nativeQuery = true)
    List<Object[]> findReceiverFeedbackDetails(@Param("email") String email);
}
