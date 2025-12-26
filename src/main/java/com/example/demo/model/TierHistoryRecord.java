package com.example.demo.model;

import java.time.LocalDateTime;

public class TierHistoryRecord {

    private Long id;
    private CustomerProfile customer;
    private String fromTier;
    private String toTier;
    private LocalDateTime upgradedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }

    public String getFromTier() { return fromTier; }
    public void setFromTier(String fromTier) { this.fromTier = fromTier; }

    public String getToTier() { return toTier; }
    public void setToTier(String toTier) { this.toTier = toTier; }

    public LocalDateTime getUpgradedAt() { return upgradedAt; }
    public void setUpgradedAt(LocalDateTime upgradedAt) { this.upgradedAt = upgradedAt; }
}
