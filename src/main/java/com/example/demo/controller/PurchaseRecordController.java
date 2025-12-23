package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    @Autowired
    private PurchaseRecordRepository purchaseRecordRepository;

    // 1. POST / - Record purchase
    @PostMapping("/")
    public PurchaseRecord recordPurchase(@RequestBody PurchaseRecord purchase) {
        return purchaseRecordRepository.save(purchase);
    }

    // 2. GET /customer/{customerId} - Get for customer
    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecord> getPurchasesByCustomer(@PathVariable String customerId) {
        return purchaseRecordRepository.findByCustomerBusinessId(customerId);
    }

    // 3. GET /{id} - Get by ID (Missing ah irundhadhu)
    @GetMapping("/{id}")
    public PurchaseRecord getPurchaseById(@PathVariable Long id) {
        return purchaseRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with id: " + id));
    }

    // 4. GET / - List all (Missing ah irundhadhu)
    @GetMapping("/")
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRecordRepository.findAll();
    }
}