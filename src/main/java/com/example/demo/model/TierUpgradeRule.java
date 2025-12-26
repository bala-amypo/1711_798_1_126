package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fromTier", "toTier"})
})
public class TierUpgradeRule {

    @Id
    @GeneratedValue
    private Long id;

    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;
    private boolean active;

    // getters & setters
}
