package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String token) {
        Map<String, Object> response = userService.login(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
