package com.example.demo.service.Impl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final List<TierHistoryRecord> history = new ArrayList<>();

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return history;
    }

    @Override
    public TierHistoryRecord saveHistory(TierHistoryRecord record) {
        history.add(record);
        return record;
    }
}
