package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private CustomerProfile customer;

    private LocalDate visitDate;

    private String channel;

    // getters & setters
}
