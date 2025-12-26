/*package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import java.util.List;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule);

    List<TierUpgradeRule> getActiveRules();

    TierUpgradeRule getRule(String fromTier, String toTier);

    List<TierUpgradeRule> getAllRules();
}
*/
package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repo;

    public TierUpgradeRuleService(TierUpgradeRuleRepository repo) {
        this.repo = repo;
    }

    public TierUpgradeRule createRule(TierUpgradeRule r) {
        return repo.save(r);
    }

    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule r = repo.findById(id).orElseThrow();
        r.setFromTier(updatedRule.getFromTier());
        r.setToTier(updatedRule.getToTier());
        r.setMinSpend(updatedRule.getMinSpend());
        r.setMinVisits(updatedRule.getMinVisits());
        r.setActive(updatedRule.getActive());
        return repo.save(r);
    }

    public List<TierUpgradeRule> getActiveRules() {
        return repo.findAll().stream().filter(TierUpgradeRule::getActive).toList();
    }

    public Optional<TierUpgradeRule> getRule(String fromTier, String toTier) {
        return repo.findByFromTierAndToTier(fromTier, toTier);
    }

    public List<TierUpgradeRule> getAllRules() {
        return repo.findAll();
    }
}
