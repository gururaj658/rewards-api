package com.rewards.rewards_api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Month;
import java.util.Map;

@Data
@AllArgsConstructor
public class RewardResponse {
    private String customerId;
    private Map<Month, Integer> monthlyPoints;
    private int totalPoints;
}
