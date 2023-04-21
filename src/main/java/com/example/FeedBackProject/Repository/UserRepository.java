package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String > {


    User findByEmailId(String s);
    List<User> findByManagerEmpId(String managerEmpId);




    @Query(value = "select name, email_id from user u1 where manager_emp_id=(select emp_id from user u2 where u2.email_id=:email) ", nativeQuery = true)
    List<Object[]> findEmployeesUnderManager(@Param("email") String email);


}
