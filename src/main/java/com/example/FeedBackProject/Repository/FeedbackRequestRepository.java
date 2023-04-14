package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRequestRepository extends JpaRepository<FeedbackRequest, Long> {

    @Query(value = "select fr.feedback_requester,e.name,e.emp_id, fr.feedback_id  from feedback_request fr, user e "+
            "where fr.status=0 and fr.feedback_provider=:email and fr.feedback_requester=e.email_id", nativeQuery = true)
    List<Object[]> findReceiverFeedbackDetails(@Param("email") String email);



    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=0 and fr.feedback_provider=e.email_id;",nativeQuery = true)
    List<Object[]> findPendingResponses(@Param("email") String email);

    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=1 and fr.feedback_provider=e.email_id;",nativeQuery = true)

    List<Object[]> findCompletedResponses(@Param("email") String email);


}
