package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.Result;
<<<<<<< HEAD
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
=======
import com.example.FeedBackProject.EntityDTO.ResultDTO;
import com.example.FeedBackProject.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> 191952c7d84d929673749071e8c440bf028c535a
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
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
=======
@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    private ResultService resultService;


>>>>>>> 191952c7d84d929673749071e8c440bf028c535a
}
