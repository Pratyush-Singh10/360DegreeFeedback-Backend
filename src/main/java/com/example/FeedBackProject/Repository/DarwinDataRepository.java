package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.DarwinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DarwinDataRepository extends JpaRepository<DarwinData, String > {
}
