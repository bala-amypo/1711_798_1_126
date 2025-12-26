package com.example.demo.service.impl;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final List<VisitRecord> list = new ArrayList<>();

    @Override
    public VisitRecord recordVisit(VisitRecord v) {
        if (!List.of("STORE", "APP", "WEB").contains(v.getChannel()))
            throw new IllegalArgumentException("Invalid channel");

        v.setId((long) (list.size() + 1));
        list.add(v);
        return v;
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long cid) {
        return list;
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return list;
    }

    @Override
    public Optional<VisitRecord> getVisitById(Long id) {
        return list.stream().filter(v -> v.getId().equals(id)).findFirst();
    }
}
