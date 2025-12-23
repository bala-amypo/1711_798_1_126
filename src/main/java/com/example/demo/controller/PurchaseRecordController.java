package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordService(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        return repository.save(purchase);
    }

    public List<PurchaseRecord> getPurchasesByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    // 🔴 ADD THIS
    public PurchaseRecord getPurchaseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 🔴 ADD THIS
    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }
}
