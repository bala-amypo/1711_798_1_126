package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"fromTier", "toTier"})})
public class TierUpgradeRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private boolean active;
}