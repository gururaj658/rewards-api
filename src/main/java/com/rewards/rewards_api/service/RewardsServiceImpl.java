package com.rewards.rewards_api.service;

import com.rewards.rewards_api.dto.RewardResponse;
import com.rewards.rewards_api.exception.CustomerNotFoundException;
import com.rewards.rewards_api.model.Transaction;
import com.rewards.rewards_api.repository.TransactionRepository;
import com.rewards.rewards_api.util.RewardCalculator;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsService {

    private final TransactionRepository repository;

    public RewardsServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RewardResponse> getAllRewards() {
        List<Transaction> transactions = repository.getAllTransactions();

        Map<String, List<Transaction>> groupedByCustomer =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId));

        List<RewardResponse> responses = new ArrayList<>();

        for (String customerId : groupedByCustomer.keySet()) {
            responses.add(calculateCustomerRewards(customerId, groupedByCustomer.get(customerId)));
        }

        return responses;
    }

    @Override
    public RewardResponse getRewardsByCustomer(String customerId) {
        List<Transaction> transactions = repository.getAllTransactions()
                .stream()
                .filter(t -> t.getCustomerId().equals(customerId))
                .toList();

        if (transactions.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found: " + customerId);
        }

        return calculateCustomerRewards(customerId, transactions);
    }

    private RewardResponse calculateCustomerRewards(String customerId, List<Transaction> transactions) {

        Map<Month, Integer> monthlyPoints = transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getDate().getMonth(),
                        Collectors.summingInt(t -> RewardCalculator.calculatePoints(t.getAmount()))
                ));

        int total = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();

        return new RewardResponse(customerId, monthlyPoints, total);
    }

}
