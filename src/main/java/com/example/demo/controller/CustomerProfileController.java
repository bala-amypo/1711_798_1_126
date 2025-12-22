package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    // Interface-ah mattum thaan inga use panrom (Loose Coupling)
    private final CustomerProfileService service;

    // Strict Constructor Injection
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

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerProfile> getCustomer(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getCustomerByBusinessId(customerId));
    }
}