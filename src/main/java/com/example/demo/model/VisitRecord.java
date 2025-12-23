package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_record")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerBusinessId;
    private LocalDateTime visitDate;

    // Default Constructor
    public VisitRecord() {}

    @PrePersist
    protected void onCreate() {
        this.visitDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerBusinessId() { return customerBusinessId; }
    public void setCustomerBusinessId(String customerBusinessId) { this.customerBusinessId = customerBusinessId; }

    public LocalDateTime getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }
}