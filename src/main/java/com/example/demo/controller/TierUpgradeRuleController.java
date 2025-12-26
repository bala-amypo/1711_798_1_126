/*package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
@Tag(name = "Tier Rule API")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/lookup")
    public TierUpgradeRule getRule(
            @RequestParam String fromTier,
            @RequestParam String toTier) {
        return service.getRule(fromTier, toTier);
    }
}*/
package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @PostMapping("/")
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(@PathVariable Long id, @RequestBody TierUpgradeRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/")
    public List<TierUpgradeRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/lookup")
    public Optional<TierUpgradeRule> lookup(@RequestParam String fromTier, @RequestParam String toTier) {
        return service.getRule(fromTier, toTier);
    }
}

