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
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/getDetails/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/getDetails")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getDetails/user/{id}")
    public User getUserById(@PathVariable String id) {
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

    @GetMapping("/employeesUnderBUHead/{email}")
    public List<Object[]> findEmployeesUnderBUHead(@PathVariable String email) {
        return userService.findEmployeesUnderBUHead(email);
    }

    @PostMapping("/postDetails")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/isManager/{emailId}")
    public ResponseEntity<Boolean> isManager(@PathVariable String emailId) {
        boolean isManager = userService.isManager(emailId);
        return new ResponseEntity<>(isManager, HttpStatus.OK);
    }


        @GetMapping("/checkRole/{email}")
        public ResponseEntity<String> getUserRole(@PathVariable String email) {
            String role = userService.getUserRoleByEmail(email);
            if (role == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(role);
        }

        @GetMapping("/getUserByBU/{email}")
        public List<User> getUserByBU(@PathVariable String email){
            List<User> nUser=userService.getUserByBU(email);
            return nUser;
        }

    //    @GetMapping("/Emp")
    //    public List<Object[]> getAllEmployee(@RequestParam("var") String var) {
    //        return userService.getEmp(var);
    //    }

    //    @GetMapping("/empByName/{name}")
    //    public User getAllEmp(@PathVariable String name){
    //        System.out.println("here");
    //        return userService.getEmpName(name);
    //    }
}





