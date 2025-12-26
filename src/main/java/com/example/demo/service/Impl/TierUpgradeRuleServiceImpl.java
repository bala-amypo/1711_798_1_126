package com.example.demo.service.Impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final List<TierUpgradeRule> rules = new ArrayList<>();

    @Override
    public TierUpgradeRule getRule(String businessId, String tierName) {
        return rules.stream()
                .filter(r -> r.getBusinessId().equals(businessId) && r.getTierName().equals(tierName))
                .findFirst().orElse(null);
    }

    @Override
    public TierUpgradeRule saveRule(TierUpgradeRule rule) {
        rules.add(rule);
        return rule;
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return rules;
    }
}
