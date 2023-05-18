package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String > {


    User findByEmailId(String s);

//    User findByName(String s);
    List<User> findByManagerEmpId(String managerEmpId);

    User findByEmpId(String empId);


    @Query(value = "select name, email_id from user u1 where manager_emp_id=(select emp_id from user u2 where u2.email_id=:email) ", nativeQuery = true)
    List<Object[]> findEmployeesUnderManager(@Param("email") String email);

    @Query(value = "select name,email_id from user where bu_name in (select bu_name from user where email_id=:email) AND email_id !=:email", nativeQuery = true)
    List<Object[]> findEmployeesUnderBUHead(@Param("email") String email);


    @Query(value = "SELECT name, email_id FROM user WHERE bu_name = " +
            "(SELECT bu_name FROM user WHERE email_id = :email) " +
            "AND email_id != :email",nativeQuery = true)
    List<User> findUserByBU(@Param("email") String email);

//    @Query(value = "SELECT emp.name FROM User emp " +
//            "WHERE lower(emp.name) LIKE lower(CONCAT('%', :var, '%')) " +
//            "OR lower(emp.name) LIKE lower(CONCAT('%', :var)) " +
//            "OR lower(emp.name) LIKE lower(CONCAT(:var, '%'))",nativeQuery = true)
//    List<Object[]> getEmpByName(String var);

}
