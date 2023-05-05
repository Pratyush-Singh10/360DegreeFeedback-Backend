package com.example.FeedBackProject.Controller;

import com.example.FeedBackProject.Entity.DarwinData;
import com.example.FeedBackProject.Services.DarwinDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("darwinData/api/")
public class DarwinDataController {

    @Autowired
    private DarwinDataService darwinDataService;

    @GetMapping("/")
    public ResponseEntity<List<DarwinData>> getAllEmpData(){
        List<DarwinData> list = this.darwinDataService.getAllEmp();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
