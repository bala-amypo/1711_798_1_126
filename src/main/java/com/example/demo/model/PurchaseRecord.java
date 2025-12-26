package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customer;

    @Column(nullable = false)
    private Double amount;

    private LocalDate purchaseDate;
    private String storeLocation;

    @PrePersist
    protected void validate() {
        if (amount != null && amount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be positive");
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { 
        if(amount <= 0) throw new IllegalArgumentException("Amount must be > 0");
        this.amount = amount; 
    }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public String getStoreLocation() { return storeLocation; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }
}