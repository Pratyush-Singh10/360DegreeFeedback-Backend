package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.example.FeedBackProject.EntityDTO.ResultDTO;
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/getRating/{id}")
    public List<Object[]> getRatings(@PathVariable Long id) {
        return resultService.findRating(id);
    }
    @PostMapping("/storeRes/{id}")
    public Map<String, Object> storeResult(@PathVariable Long id, @RequestBody Map<String , Object> map) {
        return resultService.storeResult(id, map);
    }
}