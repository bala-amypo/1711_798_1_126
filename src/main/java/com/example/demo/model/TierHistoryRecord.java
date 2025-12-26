/*package com.example.demo.model;

import java.time.LocalDateTime;

public class TierHistoryRecord {

    private Long id;
    private CustomerProfile customer;
    private String oldTier;
    private String newTier;
    private LocalDateTime upgradedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public String getOldTier() {
        return oldTier;
    }

    public void setOldTier(String oldTier) {
        this.oldTier = oldTier;
    }

    public String getNewTier() {
        return newTier;
    }

    public void setNewTier(String newTier) {
        this.newTier = newTier;
    }

    public LocalDateTime getUpgradedAt() {
        return upgradedAt;
    }

    public void setUpgradedAt(LocalDateTime upgradedAt) {
        this.upgradedAt = upgradedAt;
    }
}
*/
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CustomerProfile customer;

    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    @PrePersist
    public void prePersist() {
        changedAt = LocalDateTime.now();
    }

    // Getters and Setters
}
