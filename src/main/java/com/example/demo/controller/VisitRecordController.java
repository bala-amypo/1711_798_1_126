package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    // 1. POST / - Record visit
    @PostMapping("/")
    public VisitRecord recordVisit(@RequestBody VisitRecord visit) {
        return visitRecordRepository.save(visit);
    }

    // 2. GET /customer/{customerId} - Get for customer
    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable String customerId) {
        return visitRecordRepository.findByCustomerBusinessId(customerId);
    }

    // 3. GET /{id} - Get by ID
    @GetMapping("/{id}")
    public VisitRecord getVisitById(@PathVariable Long id) {
        return visitRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit record not found with id: " + id));
    }

    // 4. GET / - List all
    @GetMapping("/")
    public List<VisitRecord> getAllVisits() {
        return visitRecordRepository.findAll();
    }
}