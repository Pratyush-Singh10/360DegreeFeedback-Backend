package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String > {

    User findByEmailId(String emailId);
    List<User> findByRole(String role);

}
