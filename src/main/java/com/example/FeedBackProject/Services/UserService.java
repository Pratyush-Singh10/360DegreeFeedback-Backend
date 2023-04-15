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

//    public Map<String, Object> login (String token){
//
//        String[] chunks = token.split("\\.");
//        String payload = new String(Base64.decodeBase64(chunks[1]));
//        Map<String, String> map = new HashMap<>();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//                map = mapper.readValue(payload, new TypeReference<Map<String, String>>() {
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String ROLE = "USER";
//        int isActive = 1;
//        Map<String, Object> response = new HashMap<>();
//        Optional<User> user = userRepository.findById(map.get("sub"));
//
//        if (user.equals(Optional.empty()))
//        {
//            User newUser = new User(map.get("sub"), map.get("name"), map.get("email"), ROLE, isActive);
//            userRepository.save(newUser);
//            response.put("user", newUser);
//        }
//        else {
//            response.put("message ", "Login Successful");
//            response.put("user", user.get());
//        }
//        User newUser = (User) response.get("user");
//        return response;
//    }

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
        User obj=userRepository.findById(emailId).orElse(null);
        if(usr.getName()!=null)obj.setName(usr.getName());
        if(usr.getEmailId()!=null) obj.setEmailId(usr.getEmailId());
        if(usr.getRole()!=null) obj.setRole(usr.getRole());
        return userRepository.save(obj);
    }

    public String decodeGoogleToken(String token) {
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

        User user=this.userRepository.findByEmailId(map.get("email"));
        if(user==null) {
            BCryptPasswordEncoder b=new BCryptPasswordEncoder();
            String password= b.encode("PASSWORD");
            User newuser=new User();
            newuser.setEmpId(map.get("sub"));
            newuser.setEmailId(map.get("email"));
            newuser.setName(map.get("given_name"));
            newuser.setPassword(password);
            newuser.setRole("USER");
            newuser.setIsActive(1);
//            UserDto userDto = new UserDto(null, map.get("email"), map.get("given_name"), map.get("family_name"), "USER",password);
//            System.out.println(userDto);
            User nuser = this.modelMapper.map(newuser, User.class);
            this.userRepository.save(nuser);
        }
        return map.get("email");
    }









}
