package com.example.demo.service.Impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final List<CustomerProfile> customers = new ArrayList<>();

    @Override
    public Optional<CustomerProfile> findByCustomerId(String customerId) {
        return customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst();
    }

    @Override
    public CustomerProfile saveCustomerProfile(CustomerProfile customer) {
        customers.add(customer);
        return customer;
    }
}
