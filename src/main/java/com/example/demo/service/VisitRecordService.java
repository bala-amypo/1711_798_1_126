package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.List;
import java.util.Optional;

public interface VisitRecordService {
    VisitRecord recordVisit(VisitRecord v);
    List<VisitRecord> getVisitsByCustomer(Long cid);
    List<VisitRecord> getAllVisits();
    Optional<VisitRecord> getVisitById(Long id);
}
