package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CustomerProfile customer;

    private Double amount;

    private LocalDate purchaseDate;

    private String storeLocation;

    // getters & setters
}
