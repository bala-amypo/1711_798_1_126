package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final List<PurchaseRecord> list = new ArrayList<>();

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord p) {
        if (p.getAmount() <= 0)
            throw new IllegalArgumentException("Invalid amount");

        p.setId((long) (list.size() + 1));
        list.add(p);
        return p;
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long cid) {
        return list;
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return list;
    }

    @Override
    public Optional<PurchaseRecord> getPurchaseById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
