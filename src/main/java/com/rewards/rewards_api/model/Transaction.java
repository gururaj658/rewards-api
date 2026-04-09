package com.rewards.rewards_api.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Transaction {
    private String customerId;
    private double amount;
    private LocalDate date;

   /* public Transaction(String c1, int i, LocalDate localDate) {
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }*/
}
