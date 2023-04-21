package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRequestRepository extends JpaRepository<FeedbackRequest, Long> {


    List<FeedbackRequest> findByrEmailAndStatus(String rEmail, int status);

    @Query(value = "select fr.feedback_requester,e.name,e.emp_id, fr.feedback_id  from feedback_request fr, user e "+
            "where fr.status=0 and fr.feedback_provider=:email and fr.feedback_requester=e.email_id", nativeQuery = true)
    List<Object[]> findReceiverFeedbackDetails(@Param("email") String email);




    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=0 and fr.feedback_provider=e.email_id;",nativeQuery = true)
    List<Object[]> findPendingResponses(@Param("email") String email);

    @Query(value = "select e.name,e.emp_id,fr.feedback_provider from feedback_request fr, user e "+
            "where fr.feedback_requester=:email and status=1 and fr.feedback_provider=e.email_id;",nativeQuery = true)

    List<Object[]> findCompletedResponses(@Param("email") String email);


    @Query(value = "select e.emp_id,e.name,fr.feedback_provider,fr.status,fr.feedback_id " +
            "from feedback_request fr, user e where fr.feedback_requester=:email "+
            "and fr.feedback_provider=e.email_id ",nativeQuery = true)
    List<Object[]> findFeedbackProviders(@Param("email") String email);


    @Query(value = "select fr.feedback_comment from feedback_request fr where fr.feedback_id=:id and status=1;",nativeQuery = true)
    String findComment(@Param("id") long id);


    @Query(value = "SELECT fr.feedback_id, fr.project_name, fr.feedback_provider, fr.start_date, fr.end_date, fr.self_input, fr.feedback_comment, "+
    "MAX(CASE WHEN q.attribute_id = 1 THEN r.rating ELSE NULL END) AS attribute1, "+
    "MAX(CASE WHEN q.attribute_id = 2 THEN r.rating ELSE NULL END) AS attribute2, "+
    "MAX(CASE WHEN q.attribute_id = 3 THEN r.rating ELSE NULL END) AS attribute3, "+
    "MAX(CASE WHEN q.attribute_id = 4 THEN r.rating ELSE NULL END) AS attribute4, "+
    "MAX(CASE WHEN q.attribute_id = 5 THEN r.rating ELSE NULL END) AS attribute5, "+
    "MAX(CASE WHEN q.attribute_id = 6 THEN r.rating ELSE NULL END) AS attribute6, "+
    "MAX(CASE WHEN q.attribute_id = 7 THEN r.rating ELSE NULL END) AS attribute7, "+
    "MAX(CASE WHEN q.attribute_id = 8 THEN r.rating ELSE NULL END) AS attribute8, "+
    "MAX(CASE WHEN q.attribute_id = 9 THEN r.rating ELSE NULL END) AS attribute9, "+
    "MAX(CASE WHEN q.attribute_id = 10 THEN r.rating ELSE NULL END) AS attribute10 "+
    "FROM feedback_request fr "+
    "JOIN result r ON fr.feedback_id = r.feedback_id "+
    "JOIN questions q ON r.attribute_id = q.attribute_id "+
    "WHERE fr.feedback_requester = :rEmail ", nativeQuery = true)
    List<Object[]> findResult(@Param("rEmail") String rEmail);




}
