package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import java.util.List;
import java.util.Optional;

public interface PurchaseRecordService {
    PurchaseRecord recordPurchase(PurchaseRecord p);
    List<PurchaseRecord> getPurchasesByCustomer(Long cid);
    List<PurchaseRecord> getAllPurchases();
    Optional<PurchaseRecord> getPurchaseById(Long id);
}
