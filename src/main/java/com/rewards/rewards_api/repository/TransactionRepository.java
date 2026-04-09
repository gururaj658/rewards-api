package com.rewards.rewards_api.repository;

import com.rewards.rewards_api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepository {
    public List<Transaction> getAllTransactions() {
        return List.of(
                new Transaction("C1", 120, LocalDate.now().minusMonths(2)),
                new Transaction("C1", 75, LocalDate.now().minusMonths(1)),
                new Transaction("C1", 60, LocalDate.now()),

                new Transaction("C2", 200, LocalDate.now().minusMonths(2)),
                new Transaction("C2", 40, LocalDate.now().minusMonths(1)),
                new Transaction("C2", 90, LocalDate.now())
        );
    }

}
