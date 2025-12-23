package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile customer) {
        return ResponseEntity.ok(service.createCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerProfile>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    // Inga question-la path id-nu ketrukanga, change to {id}
    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> getCustomer(@PathVariable String id) {
        return ResponseEntity.ok(service.getCustomerByBusinessId(id));
    }

    // --- PUDHU CODE INGA ADD PANNUM ---

    // 1. PUT /{id}/tier - Update manual tier
    @PutMapping("/{id}/tier")
    public ResponseEntity<CustomerProfile> updateTier(@PathVariable String id, @RequestBody String newTier) {
        // Service-la updateTier logic-ah call pannunga
        return ResponseEntity.ok(service.updateCustomerTier(id, newTier));
    }

    // 2. GET /lookup/{customerId} - Exact match for your question
    @GetMapping("/lookup/{customerId}")
    public ResponseEntity<CustomerProfile> lookupCustomer(@PathVariable String customerId) {
        // Lookup logic simple-ah same getCustomer logic dhaan
        return ResponseEntity.ok(service.getCustomerByBusinessId(customerId));
    }
}