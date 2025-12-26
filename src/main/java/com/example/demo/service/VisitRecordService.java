/*package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.List;

public interface VisitRecordService {

    VisitRecord recordVisit(VisitRecord visit);

    List<VisitRecord> getVisitsByCustomer(Long customerId);

    List<VisitRecord> getAllVisits();

    VisitRecord getVisitById(Long id);
}
*/
package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VisitRecordService {

    private final VisitRecordRepository repo;

    public VisitRecordService(VisitRecordRepository repo) {
        this.repo = repo;
    }

    public VisitRecord recordVisit(VisitRecord v) {
        if (!List.of("STORE", "APP", "WEB").contains(v.getChannel()))
            throw new IllegalArgumentException("Invalid visit channel");
        return repo.save(v);
    }

    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    public List<VisitRecord> getAllVisits() {
        return repo.findAll();
    }

    public VisitRecord getVisitById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
