package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {
    CustomerProfile createCustomer(CustomerProfile customer);
    List<CustomerProfile> getAllCustomers();
    CustomerProfile getCustomerByBusinessId(String customerId);
    // Pudhu method for tier update
    CustomerProfile updateCustomerTier(String customerId, String newTier);
}