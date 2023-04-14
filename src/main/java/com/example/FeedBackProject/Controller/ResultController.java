package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Result;
import com.example.FeedBackProject.EntityDTO.ResultDTO;
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    private ResultService resultService;
    @GetMapping("/getRating/{id}")
    public List<Object[]> getRatings(@PathVariable Long id) {
        return resultService.findRating(id);
    }
}
