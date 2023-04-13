package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Services.JWTDecoderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class JWTDecoderController {

    @Autowired
    private JWTDecoderService jwtDecoderService;

    @PostMapping(value = "/jwt/decode/{token}", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String decodeJWT(@PathVariable String token) throws UnsupportedEncodingException {
        return jwtDecoderService.decodingJWT(token);
    }

}
