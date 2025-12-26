package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import java.util.*;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    TierUpgradeRule updateRule(Long id, TierUpgradeRule rule);

    List<TierUpgradeRule> getActiveRules();

    Optional<TierUpgradeRule> getRule(String fromTier, String toTier);

    List<TierUpgradeRule> getAllRules();
}
