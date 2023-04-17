package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Map<String, Object> login (String token){

        String[] chunks = token.split("\\.");
        String payload = new String(Base64.decodeBase64(chunks[1]));
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
                map = mapper.readValue(payload, new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ROLE = "USER";
        int isActive = 1;
        String password="PASSWORD";
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.findById(map.get("sub"));

        if (user.equals(Optional.empty()))
        {
            User newUser = new User();
            newUser.setEmpId(map.get("sub"));
            newUser.setEmailId(map.get("email"));
            newUser.setName(map.get("name"));
            newUser.setPassword(password);
            newUser.setRole("USER");
            newUser.setIsActive(1);
            userRepository.save(newUser);
            response.put("user", newUser);
        }
        else {
            response.put("message ", "Login Successful");
            response.put("user", user.get());
        }
        User newUser = (User) response.get("user");
        return response;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmailId(email);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(String emailId,User usr){

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmailId(emailId));
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setRole(usr.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }

//    public String decodeGoogleToken(String token) {
//        String[] chunks = token.split("\\.");
//        String payload = new String(Base64.decodeBase64(chunks[1]));
//        Map<String, String> map = new HashMap<>();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            map = mapper.readValue(payload, new TypeReference<Map<String, String>>() {
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        User user = this.userRepository.findByEmailId(map.get("email"));
//        if (user == null) {
//            BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//            String password = b.encode("PASSWORD");
//            User newuser = new User();
//            newuser.setEmpId(map.get("sub"));
//            newuser.setEmailId(map.get("email"));
//            newuser.setName(map.get("name"));
//            newuser.setPassword(password);
//            newuser.setRole("USER");
//            newuser.setIsActive(1);
//            User nuser = this.modelMapper.map(newuser, User.class);
//            this.userRepository.save(nuser);
//        }
//        return map.get("email");
//    }

    public void updateUserIsActive(String empId) {
        User user = userRepository.findById(empId).orElseThrow(() -> new RuntimeException("User not found with empId: " + empId));
        user.setIsActive(0);
        userRepository.save(user);
    }

}
