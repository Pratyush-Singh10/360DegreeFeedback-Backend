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
<<<<<<< HEAD
=======

>>>>>>> 4f561c3b8109597ef728dc0ff1bb8899e82a7560
    private ResultService resultService;
    @GetMapping("/getRating/{id}")
    public List<Object[]> getRatings(@PathVariable Long id) {
        return resultService.findRating(id);
<<<<<<< HEAD
    }
    @PostMapping("/storeRes")
    public Map<String, Object> storeResult(@RequestBody Map<String , Object> map) {
        return resultService.storeResult(map);
=======
>>>>>>> 4f561c3b8109597ef728dc0ff1bb8899e82a7560
    }

}
