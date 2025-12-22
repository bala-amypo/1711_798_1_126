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

    @PostMapping
    public ResponseEntity<PurchaseRecord> addPurchase(@RequestBody PurchaseRecord purchase) {
        return ResponseEntity.ok(purchaseService.recordPurchase(purchase));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PurchaseRecord>> getCustomerPurchases(@PathVariable Long customerId) {
        return ResponseEntity.ok(purchaseService.getPurchasesByCustomerId(customerId));
    }
}