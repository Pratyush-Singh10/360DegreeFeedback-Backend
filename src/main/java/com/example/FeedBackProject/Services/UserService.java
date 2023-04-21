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
//        User user=this.userRepository.findByEmailId(map.get("email"));
//        if(user==null) {
//            BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//            String password = b.encode("password");
//            User newUser = new User();
//            newUser.setEmpId(map.get("sub"));
//            newUser.setEmailId(map.get("email"));
//            newUser.setName(map.get("name"));
//            newUser.setPassword(password);
//            newUser.setRole("USER");
//            newUser.setIsActive(1);
//            userRepository.save(newUser);
//        }
//        return map.get("email");
//    }
    public Map<String, Object> login(String token) {

        System.out.println("This is Working");
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
        String password = "PASSWORD";
        Map<String, Object> response = new HashMap<>();
        User user = userRepository.findByEmailId(map.get("email"));

        if (user.equals(Optional.empty())) {
            User newUser = new User();
            newUser.setEmpId(map.get("sub"));
            newUser.setEmailId(map.get("email"));
            newUser.setName(map.get("name"));
            newUser.setPassword(password);
            userRepository.save(newUser);
            response.put("user", newUser);
        } else {
            response.put("message ", "Login Successful");
            response.put("user", user);
        }
        User newUser = (User) response.get("user");
        return response;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmailId(email);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

//    public User updateUser(String emailId, User usr) {
//        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmailId(emailId));
//        if (optionalUser.isPresent()) {
//            User existingUser = optionalUser.get();
//            String currentRole = existingUser.getRole();
//            String newRole = usr.getRole();
//
//            if (currentRole.equals("ADMIN") && (newRole.equals("USER") || newRole.equals("MANAGER") || newRole.equals("BU HEAD"))) {
//                List<User> admins = userRepository.findByRole("ADMIN");
//                if (admins.size() == 1 && admins.get(0).getEmailId().equals(existingUser.getEmailId())) {
//                    throw new RuntimeException("Cannot change role to USER. There must be at least one ADMIN user.");
//                }
//            }
//
//            existingUser.setRole(newRole);
//            return userRepository.save(existingUser);
//        }
//        return null;
//    }
//
//}

//
//    public void updateUserIsActive(String emailId) {
//        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmailId(emailId));
//        if (optionalUser.isPresent()) {
//            User existingUser = optionalUser.get();
//            existingUser.setIsActive(0);
//            userRepository.save(existingUser);
//        }
//    }

    public List<Object[]> findEmployeesUnderManager(String email) {
        List<Object[]> employees=userRepository.findEmployeesUnderManager(email);
        return employees;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

//    public boolean isEmailIdPresent(String emailId) {
//        User user = userRepository.findByEmailId(emailId);
//        if (user != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }


    public boolean isManager(String email) {
        User user = userRepository.findByEmailId(email);

        if (user == null) {
            throw new IllegalArgumentException("User not found for email: " + email);
        }

        // Check if the user has any subordinates
        List<User> subordinates = userRepository.findByManagerEmpId(user.getEmpId());
        return !subordinates.isEmpty();
    }

}

