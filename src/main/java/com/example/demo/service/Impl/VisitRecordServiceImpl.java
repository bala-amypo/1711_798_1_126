package com.example.demo.service.Impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final List<VisitRecord> visits = new ArrayList<>();

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {
        visits.add(visit);
        return visit;
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return visits;
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return visits.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        List<VisitRecord> result = new ArrayList<>();
        for (VisitRecord v : visits) {
            if (v.getCustomerId().equals(customerId)) result.add(v);
        }
        return result;
    }
}
