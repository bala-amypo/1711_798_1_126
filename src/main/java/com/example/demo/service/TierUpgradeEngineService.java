package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;
import java.util.*;

public interface TierUpgradeEngineService {

    TierHistoryRecord evaluateAndUpgradeTier(Long customerId);

    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);

    List<TierHistoryRecord> getAllHistory();
}
