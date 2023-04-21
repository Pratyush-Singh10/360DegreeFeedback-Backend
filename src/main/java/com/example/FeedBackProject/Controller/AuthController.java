//package com.example.FeedBackProject.Controller;
//
//import com.example.FeedBackProject.Entity.User;
//import com.example.FeedBackProject.Security.JwtTokenUtils;
//import com.example.FeedBackProject.Services.UserService;
//import com.example.FeedBackProject.utils.AuthRequest;
//import com.example.FeedBackProject.utils.AuthResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//public class AuthController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    JwtTokenUtils jwtTokenUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest){
//        try{
//            String email = this.userService.decodeGoogleToken(authRequest.getToken());
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, "PASSWORD"));
//
//            User user = (User) authentication.getPrincipal();
//            String accessToken = jwtTokenUtil.generateAccessToken(user);
//            AuthResponse authResponse = new AuthResponse(user.getEmailId(),user.getName(), accessToken);
//            return new ResponseEntity<>(authResponse, HttpStatus.OK);
//        }
//        catch (BadCredentialsException ex){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
////    @PostMapping("/decode")
////    public ResponseEntity<Object> decodeToken(@RequestBody String token) {
////        System.out.println(token);
////        String email = userService.decodeGoogleToken(token);
////        return new ResponseEntity<>(response, HttpStatus.OK);
////    }
//
//}
