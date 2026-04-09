package com.rewards.rewards_api;

import com.rewards.rewards_api.exception.CustomerNotFoundException;
import com.rewards.rewards_api.repository.TransactionRepository;
import com.rewards.rewards_api.service.RewardsService;
import com.rewards.rewards_api.service.RewardsServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsServiceTest {
    private final TransactionRepository repository = new TransactionRepository();
    private final RewardsService service = new RewardsServiceImpl(repository);

    @Test
    void testInvalidCustomerShouldThrowException() {
        assertThrows(CustomerNotFoundException.class, () -> {
            service.getRewardsByCustomer("INVALID_ID");
        });
    }
}
