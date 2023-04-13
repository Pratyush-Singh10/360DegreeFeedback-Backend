package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public List<User> getAllUser() {
            return userRepository.findAll();
    }

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
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.findById(map.get("sub"));

        if (user.equals(Optional.empty()))
        {
            User newUser = new User(map.get("sub"), map.get("name"), map.get("email"), ROLE);
            userRepository.save(newUser);
            response.put("message ", newUser.getRole() + " Logged In");
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

    public User updateUserRole(String role, String email) {
        User user = userRepository.findByEmailId(email);
        user.setRole(role);
        userRepository.save(user);
        return user;
    }


}
