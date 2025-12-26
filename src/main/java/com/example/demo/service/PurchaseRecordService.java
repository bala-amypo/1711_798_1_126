package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.*;

public interface VisitRecordService {

    VisitRecord recordVisit(VisitRecord visit);

    List<VisitRecord> getVisitsByCustomer(Long customerId);

    List<VisitRecord> getAllVisits();

    Optional<VisitRecord> getVisitById(Long id);
}
