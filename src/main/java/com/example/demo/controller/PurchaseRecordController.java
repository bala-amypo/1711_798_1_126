package com.example.demo.controller;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService purchaseService;

    public PurchaseRecordController(PurchaseRecordService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // 1️⃣ Record purchase
    @PostMapping
    public ResponseEntity<PurchaseRecord> addPurchase(@RequestBody PurchaseRecord purchase) {
        return ResponseEntity.ok(purchaseService.recordPurchase(purchase));
    }

    // 2️⃣ Get purchases by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseRecord>> getCustomerPurchases(
            @PathVariable Long customerId) {
        return ResponseEntity.ok(
                purchaseService.getPurchasesByCustomerId(customerId)
        );
    }

    // 3️⃣ 🔴 MISSING API – Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                purchaseService.getPurchaseById(id)
        );
    }

    // 4️⃣ 🔴 MISSING API – List all
    @GetMapping
    public ResponseEntity<List<PurchaseRecord>> getAll() {
        return ResponseEntity.ok(
                purchaseService.getAllPurchases()
        );
    }
}
