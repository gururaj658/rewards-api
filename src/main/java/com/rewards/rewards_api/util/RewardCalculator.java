package com.rewards.rewards_api.util;

public class RewardCalculator {
    public static int calculatePoints(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }

        if (amount > 50) {
            points += (amount - 50);
        }

        return points;
    }
}
