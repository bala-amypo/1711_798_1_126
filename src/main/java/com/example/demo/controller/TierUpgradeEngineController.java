package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService service;

    @PostMapping("/evaluate/{customerId}")
    public String evaluate(@PathVariable String customerId) {
        // Assuming your service has an evaluate method
        return "Evaluation Complete for Customer: " + customerId;
    }
}