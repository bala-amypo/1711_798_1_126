package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    @PostMapping("/")
    public String recordVisit() {
        return "Visit Recorded Successfully";
    }

    @GetMapping("/")
    public List<String> listAll() {
        return new ArrayList<>();
    }
}