package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    // ⚠️ CONSTRUCTOR ORDER MUST MATCH EXACTLY
    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo
    ) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public void evaluateAndUpgradeTier(Long customerId) {

        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(NoSuchElementException::new);

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        int visitCount = visitRepo.findByCustomerId(customerId).size();

        for (TierUpgradeRule rule : ruleRepo.findAll()) {

            if (!rule.getActive()) continue;

            if (rule.getFromTier().equals(customer.getCurrentTier())
                    && totalSpend >= rule.getMinSpend()
                    && visitCount >= rule.getMinVisits()) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getToTier());
                customerRepo.save(customer);

                TierHistoryRecord history = new TierHistoryRecord();
                history.setCustomerId(customerId);
                history.setOldTier(oldTier);
                history.setNewTier(rule.getToTier());
                history.setReason("Upgrade conditions met");

                historyRepo.save(history);
                break;
            }
        }
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }

    @Override
    public TierHistoryRecord getHistoryById(Long id) {
        return historyRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
