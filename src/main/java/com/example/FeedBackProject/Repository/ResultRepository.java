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

    @Query(value = "select q.attribute,r.rating from result r, feedback_request fr, " +
            "questions q where r.feedback_id=:id and r.feedback_id=fr.feedback_id and " +
            "q.attribute_id=r.attribute_id ", nativeQuery = true)
    List<Object[]> findRating(@Param("id") Long id);

    @Query(value = "select r.attribute_id, q.attribute, avg(r.rating) as AVG " +
            "from questions q inner join result r on q.attribute_id = r.attribute_id " +
            "inner join feedback_request f on f.feedback_id=r.feedback_id " +
            "where f.feedback_requester= :email " +
            "group by r.attribute_id, q.attribute ",nativeQuery = true)
    List<Object[]> findAvgRating(@Param("email") String email);

}
