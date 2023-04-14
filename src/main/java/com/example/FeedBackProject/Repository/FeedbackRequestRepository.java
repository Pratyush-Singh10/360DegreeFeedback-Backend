package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRequestRepository extends JpaRepository<FeedbackRequest, Long> {

    @Query(value = "select fr.feedback_requester,e.name,e.emp_id from feedback_request fr, user e "+
            "where fr.status=0 and fr.feedback_provider=:email and fr.feedback_requester=e.email_id", nativeQuery = true)
    List<Object[]> findReceiverFeedbackDetails(@Param("email") String email);


<<<<<<< HEAD
    @Query(value = "select e.name,e.emp_id,fr.g_email,status from feedback_request fr, user e "+
            "where fr.r_email=:email and fr.g_email=e.email_id;",nativeQuery = true)
    List<Object[]> findPendingResponses(@Param("email") String email);

    @Query(value = "select e.name,e.emp_id,fr.g_email from feedback_request fr, user e "+
            "where fr.r_email=:email and status=1",nativeQuery = true)
=======
    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=0 and fr.feedback_provider=e.email_id;",nativeQuery = true)
    List<Object[]> findPendingResponses(@Param("email") String email);

    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=1 and fr.feedback_provider=e.email_id;",nativeQuery = true)
>>>>>>> 191952c7d84d929673749071e8c440bf028c535a
    List<Object[]> findCompletedResponses(@Param("email") String email);


}
