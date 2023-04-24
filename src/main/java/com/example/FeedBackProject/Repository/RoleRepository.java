package com.example.FeedBackProject.Repository;

import com.example.FeedBackProject.Entity.Role;
import com.example.FeedBackProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByEmpId(User user);
}
