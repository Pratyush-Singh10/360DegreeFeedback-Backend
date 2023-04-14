package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
    ResultService resultService;

    @PostMapping(value = "/storeRes")
    public Map<Integer, Integer> storeResult(@RequestBody Map<Integer, Integer> map){
        return resultService.storeResult(map);
    }
}
