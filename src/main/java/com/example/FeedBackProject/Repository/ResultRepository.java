package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.FeedbackRequest;
import com.example.FeedBackProject.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByFeedbackId(FeedbackRequest feedbackRequest);

    @Query(value = "select q.attribute,r.rating from result r, feedback_request fr, questions q where r.feedback_id=:id and r.feedback_id=fr.feedback_id and q.attribute_id=r.attribute_id ", nativeQuery = true)
    List<Object[]> findRating(@Param("id") Long id);

    @Query(value = "select q.attribute_id, q.attribute, avg(res.rating) as AVG" +
            " from questions q, result res, feedback_request fr" +
            " where res.attribute_id=q.attribute_id and fr.feedback_requester = :email" +
            " group by res.attribute_id",nativeQuery = true)
    List<Object[]> findAvgRating(@Param("email") String email);

}
