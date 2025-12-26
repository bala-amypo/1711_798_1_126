package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.List;

public interface VisitRecordService {

    VisitRecord save(VisitRecord visit);

    List<VisitRecord> getAll();

    VisitRecord getById(Long id);

    List<VisitRecord> getByCustomerId(Long customerId);
}
