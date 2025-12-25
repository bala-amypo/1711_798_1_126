/*package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tier")
public class TierUpgradeController {

    private final TierUpgradeEngineService upgradeService;

    public TierUpgradeController(TierUpgradeEngineService upgradeService) {
        this.upgradeService = upgradeService;
    }

    @PostMapping("/evaluate/{businessId}")
    public ResponseEntity<String> evaluateTier(@PathVariable String businessId) {
        String result = upgradeService.evaluateAndUpgradeTier(businessId);
        return ResponseEntity.ok(result);
    }
}*/