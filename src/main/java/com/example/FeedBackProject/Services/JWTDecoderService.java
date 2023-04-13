package com.example.FeedBackProject.Services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class JWTDecoderService {

    public String decodingJWT(String token) throws UnsupportedEncodingException {
        String payload = token.split("\\.")[1];
        return new String(Base64.decodeBase64(payload), "UTF-8");
    }
}
