package com.example.FeedBackProject.Controller;

<<<<<<< HEAD
import com.example.FeedBackProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody String token)
    {
        Map<String,Object> response = userService.login(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
=======
public class UserController {
>>>>>>> 5bf52053f9a31eeeaae2cec9ae3d16f8fdd5ff20
}
