package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    @Query(value="select * from questions where status=1 ", nativeQuery = true)
    public List<Questions> find();
}
