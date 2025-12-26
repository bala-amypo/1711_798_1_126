package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import java.util.List;

public interface PurchaseRecordService {

    PurchaseRecord save(PurchaseRecord purchase);

    List<PurchaseRecord> getByCustomerId(Long customerId);
}
