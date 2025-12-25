package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule rule = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        rule.setFromTier(updatedRule.getFromTier());
        rule.setToTier(updatedRule.getToTier());
        rule.setMinSpend(updatedRule.getMinSpend());
        rule.setMinVisits(updatedRule.getMinVisits());
        rule.setActive(updatedRule.getActive());

        return repository.save(rule);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(TierUpgradeRule::getActive)
                .collect(Collectors.toList());
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }
}
