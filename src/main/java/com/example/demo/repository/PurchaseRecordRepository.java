package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    
    // Indha line-ah mattum add pannunga, appo dhaan error pogum
    List<PurchaseRecord> findByCustomerBusinessId(String customerId);
}