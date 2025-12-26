package com.example.demo.service.Impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final List<PurchaseRecord> records = new ArrayList<>();

    @Override
    public List<PurchaseRecord> getAllRecords() {
        return records;
    }

    @Override
    public PurchaseRecord getRecordById(Long id) {
        return records.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public PurchaseRecord saveRecord(PurchaseRecord record) {
        records.add(record);
        return record;
    }
}
