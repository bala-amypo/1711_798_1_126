package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // 🔹 Create Customer
    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    // 🔹 Get customer by DB id
    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    // 🔹 Get all customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    // 🔹 Update tier
    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {
        return customerProfileService.updateTier(id, newTier);
    }

    // 🔹 Update active status
    @PutMapping("/{id}/status")
    public CustomerProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return customerProfileService.updateStatus(id, active);
    }

    // 🔹 Lookup by customerId
    @GetMapping("/lookup/{customerId}")
    public CustomerProfile getByCustomerId(@PathVariable String customerId) {
        return customerProfileService.findByCustomerId(customerId);
    }
}
