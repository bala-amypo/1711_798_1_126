package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    List<PurchaseRecord> findByCustomerId(Long customerId);

    @Query("SELECT SUM(p.amount) FROM PurchaseRecord p WHERE p.customer.id = :customerId")
    Double sumAmountByCustomerId(Long customerId);
}