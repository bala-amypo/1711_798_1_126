package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.*;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    Optional<CustomerProfile> findByCustomerId(String customerId);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile updateStatus(Long id, boolean active);
}
