package com.rewards.rewards_api.service;


import com.rewards.rewards_api.dto.RewardResponse;

import java.util.List;

public interface RewardsService {
    List<RewardResponse> getAllRewards();
    RewardResponse getRewardsByCustomer(String customerId);
}
