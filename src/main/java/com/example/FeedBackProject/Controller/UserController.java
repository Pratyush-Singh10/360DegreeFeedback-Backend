package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Repository.UserRepository;
import com.example.FeedBackProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository user;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String token) {
        Map<String, Object> response = userService.login(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDetails/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @GetMapping("/getDetails")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getDetails/user/{id}")
    public User getUserById(@PathVariable String id){
        return userService.findById(id);
    }

//    @PutMapping("/update/{emailId}")
//    public User updateUser(@PathVariable String emailId,@RequestBody User usr){
//        return userService.updateUser(emailId,usr);
//    }
//    @PutMapping("/disableEmployee/{emailId}")
//    public ResponseEntity<String> updateUserIsActive(@PathVariable String emailId) {
//        userService.updateUserIsActive(emailId);
//        return new ResponseEntity<>("Employee is removed from an organization", HttpStatus.OK);
//    }

    @GetMapping("/employeesUnderManager/{email}")
    public List<Object[]> findEmployeesUnderManager(@PathVariable String email) {
        return userService.findEmployeesUnderManager(email);
    }

}

