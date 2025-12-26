



package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PurchaseRecordService {

    private final PurchaseRecordRepository repo;

    public PurchaseRecordService(PurchaseRecordRepository repo) {
        this.repo = repo;
    }

    public PurchaseRecord recordPurchase(PurchaseRecord p) {
        if (p.getAmount() <= 0) throw new IllegalArgumentException("Amount must be > 0");
        return repo.save(p);
    }

    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    public List<PurchaseRecord> getAllPurchases() {
        return repo.findAll();
    }

    public PurchaseRecord getPurchaseById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
