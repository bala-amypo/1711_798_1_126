package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final Map<Long, CustomerProfile> store = new HashMap<>();
    private long id = 1;

    @Override
    public CustomerProfile createCustomer(CustomerProfile c) {
        c.setId(id++);
        c.setCreatedAt(LocalDateTime.now());
        store.put(c.getId(), c);
        return c;
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        if (!store.containsKey(id))
            throw new NoSuchElementException("Customer not found");
        return store.get(id);
    }

    @Override
    public Optional<CustomerProfile> findByCustomerId(String cid) {
        return store.values()
                .stream()
                .filter(c -> c.getCustomerId().equals(cid))
                .findFirst();
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return new ArrayList<>(store.values());
    }

    @Override
    public CustomerProfile updateTier(Long id, String tier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(tier);
        return c;
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile c = getCustomerById(id);
        c.setActive(active);
        return c;
    }
}
