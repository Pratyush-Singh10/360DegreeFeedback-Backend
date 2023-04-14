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

import java.util.List;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
<<<<<<< HEAD
    private ResultService resultService;
    @GetMapping("/getRating/{id}")
    public List<Object[]> getRatings(@PathVariable Long id) {
        return resultService.findRating(id);
=======
    ResultService resultService;

    @PostMapping(value = "/storeRes")
    public Map<Integer, Integer> storeResult(@RequestBody Map<Integer, Integer> map) {
        return resultService.storeResult(map);
>>>>>>> 0496deb9be98e2f59a5cf117ace39722ad477074
    }
}
