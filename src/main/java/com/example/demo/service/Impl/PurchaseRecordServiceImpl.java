package com.example.demo.service.Impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {
    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        if (purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomerId(Long customerId) {
        // Simple logic to fetch all and filter
        return repository.findAll().stream()
                .filter(p -> p.getCustomerId().equals(customerId)).toList();
    }
}