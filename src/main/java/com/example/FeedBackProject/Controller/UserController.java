package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allEmp")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String token) {
        Map<String, Object> response = userService.login(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDetails/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/updateRole/{email}")
    public ResponseEntity<User> updateRole(@RequestBody String newRole, @PathVariable String email) {
        User updateUser = this.userService.updateUserRole(newRole,email);
        return new ResponseEntity<>(updateUser,HttpStatus.CREATED);
    }
}
