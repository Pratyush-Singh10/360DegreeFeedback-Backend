package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long> {
<<<<<<< HEAD
    @Query(
            value="select * from questions where active=1 ",
            nativeQuery = true
    )
=======

    @Query(value="select * from questions where active=1 ", nativeQuery = true)
>>>>>>> 4e9c0c1fa77752cf12537f27e9f2a53a6c80d1f2
    public List<Questions> find();
}
