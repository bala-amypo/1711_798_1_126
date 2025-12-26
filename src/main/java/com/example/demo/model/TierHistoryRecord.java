package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    @PrePersist
    public void onChange() {
        changedAt = LocalDateTime.now();
    }

    // getters & setters
}
