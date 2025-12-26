package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService engineService;

    public TierUpgradeEngineController(TierUpgradeEngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping("/evaluate/{customerId}")
    public TierHistoryRecord evaluate(@PathVariable Long customerId) {
        return engineService.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> getHistoryByCustomer(@PathVariable Long customerId) {
        return engineService.getHistoryByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public TierHistoryRecord getHistoryById(@PathVariable Long id) {
        return engineService.getAllHistory().stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/")
    public List<TierHistoryRecord> getAllHistory() {
        return engineService.getAllHistory();
    }
}
