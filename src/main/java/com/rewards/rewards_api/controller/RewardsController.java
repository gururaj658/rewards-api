package com.rewards.rewards_api.controller;

import com.rewards.rewards_api.dto.RewardResponse;
import com.rewards.rewards_api.service.RewardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/rewards")
public class RewardsController {
    private final RewardsService service;

    public RewardsController(RewardsService service) {
        this.service = service;
    }

    @GetMapping
    public List<RewardResponse> getAllRewards() {
        return service.getAllRewards();
    }

    @GetMapping("/{customerId}")
    public RewardResponse getByCustomer(@PathVariable String customerId) {
        return service.getRewardsByCustomer(customerId);
    }
}
