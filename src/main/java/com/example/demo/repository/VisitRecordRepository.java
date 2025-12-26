package com.example.demo.repository;

import com.example.demo.model.VisitRecord;
import com.example.demo.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRecordRepository 
        extends JpaRepository<VisitRecord, Long> {

    List<VisitRecord> findByCustomer(CustomerProfile customer);
}
