package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    @Autowired
    private TierUpgradeRuleRepository repository;

    @PostMapping("/")
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @GetMapping("/")
    public List<TierUpgradeRule> getAll() {
        return repository.findAll();
    }
}