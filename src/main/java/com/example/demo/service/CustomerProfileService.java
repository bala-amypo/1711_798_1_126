/*package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {

    CustomerProfile createCustomer(CustomerProfile customer);

    CustomerProfile getCustomerById(Long id);

    CustomerProfile findByCustomerId(String customerId);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile updateTier(Long id, String newTier);

    CustomerProfile updateStatus(Long id, boolean active);
}
*/
package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerProfileService {

    private final CustomerProfileRepository repo;

    // Constructor Injection
    public CustomerProfileService(CustomerProfileRepository repo) {
        this.repo = repo;
    }

    public CustomerProfile createCustomer(CustomerProfile c) {
        return repo.save(c);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Optional<CustomerProfile> findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId);
    }

    public List<CustomerProfile> getAllCustomers() {
        return repo.findAll();
    }

    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(newTier);
        return repo.save(c);
    }

    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile c = getCustomerById(id);
        c.setActive(active);
        return repo.save(c);
    }
}
