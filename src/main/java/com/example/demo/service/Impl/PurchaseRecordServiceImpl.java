package com.example.demo.service.impl;

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
    public PurchaseRecord save(PurchaseRecord purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
