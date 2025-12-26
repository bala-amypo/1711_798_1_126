package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;
import java.util.List;

public interface TierUpgradeEngineService {
    TierHistoryRecord evaluateAndUpgradeTier(Long id);
    List<TierHistoryRecord> getHistoryByCustomer(Long id);
    List<TierHistoryRecord> getAllHistory();
}
