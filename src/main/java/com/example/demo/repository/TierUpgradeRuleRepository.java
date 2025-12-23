package com.example.demo.repository;

import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {
    // Missing /lookup logic-ku idhu venum
    List<TierUpgradeRule> findByFromTierAndToTier(String fromTier, String toTier);
}