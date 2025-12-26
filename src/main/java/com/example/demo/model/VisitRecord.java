package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class VisitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customer;

    private LocalDate visitDate;
    private String channel;

    @PrePersist
    protected void validate() {
        if (channel != null && !List.of("STORE", "APP", "WEB").contains(channel)) {
            throw new IllegalArgumentException("Invalid channel");
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) {
        if (!List.of("STORE", "APP", "WEB").contains(channel)) throw new IllegalArgumentException("Invalid Channel");
        this.channel = channel;
    }
}