package com.example.demo.service.Impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository customerRepo, 
                                        PurchaseRecordRepository purchaseRepo) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    @Transactional
    public String evaluateAndUpgradeTier(String customerBusinessId) {
        CustomerProfile customer = customerRepo.findByCustomerId(customerBusinessId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        double totalSpend = purchaseRepo.findAll().stream()
                .filter(p -> p.getCustomerId().equals(customer.getId()))
                .mapToDouble(PurchaseRecord::getAmount).sum();

        // Basic upgrade rule for testing
        if ("BRONZE".equals(customer.getCurrentTier()) && totalSpend >= 500) {
            customer.setCurrentTier("SILVER");
            customerRepo.save(customer);
            return "Upgraded to SILVER. Total Spend: " + totalSpend;
        }

        return "Current Tier: " + customer.getCurrentTier() + ". Status: No upgrade criteria met.";
    }
}