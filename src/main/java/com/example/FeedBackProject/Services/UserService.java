package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.Role;
import com.example.FeedBackProject.Entity.User;
import com.example.FeedBackProject.Repository.RoleRepository;
import com.example.FeedBackProject.Repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RoleRepository roleRepository;


    public User decodeGoogleToken(String token) throws JsonProcessingException {
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

        String emailId = map.get("email");
        User user = this.userRepository.findByEmailId(emailId);
        user.setProfile(map.get("picture"));
        userRepository.save(user);
        return user;
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

//To Update the role of USER
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

    public List<Object[]> findEmployeesUnderManager(String email) {
        List<Object[]> employees=userRepository.findEmployeesUnderManager(email);
        return employees;
    }

    public List<Object[]> findEmployeesUnderBUHead(String email) {
        List<Object[]> employees=userRepository.findEmployeesUnderBUHead(email);
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



        public String getUserRoleByEmail(String email) {
            // Find the user by email
            User user = userRepository.findByEmailId(email);
            if (user == null) {
                return null;
            }
            // Check if the user has a role in the role table
            Role role = roleRepository.findByEmpId(user);
            if (role != null) {
                return role.getRole();
            }
            // Check if the user is a manager
            List<User> subordinates = userRepository.findByManagerEmpId(user.getEmpId());
            if (subordinates != null && !subordinates.isEmpty()) {
                return "manager";
            }
            // The user is an employee without a role or manager
            return "employee";
        }

        public List<User> getUserByBU(String email){
            List<User> user=userRepository.findUserByBU(email);
            return user;
        }

    public List<User> getUsersByHod(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        if (user != null) {
            String empId = user.getEmpId();
            return userRepository.findByHod(empId);
        }
        return null;
    }
//    public List<Object[]> getEmp(String var){
//        List<Object[]> searchResults = userRepository.getEmpByName(var);
//        return searchResults;
//    }
//
//    public User getEmpName(String name){
//        return userRepository.findByName(name);
//    }
}


