package com.example.FeedBackProject.Services;

import com.example.FeedBackProject.Entity.DarwinData;
import com.example.FeedBackProject.Repository.DarwinDataRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DarwinDataService {

    @Autowired
    private DarwinDataRepository darwinDataRepository;
    public List<DarwinData> getAllEmp() {
        List<DarwinData> newList = this.darwinDataRepository.findAll();
        return newList;
    }
}
