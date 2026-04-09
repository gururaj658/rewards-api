package com.rewards.rewards_api;
import com.rewards.rewards_api.util.RewardCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RewardCalculatorTest {

    @Test
    void testCalculation() {
        assertEquals(90, RewardCalculator.calculatePoints(120));
        assertEquals(25, RewardCalculator.calculatePoints(75));
        assertEquals(0, RewardCalculator.calculatePoints(40));

    }

    @Test
    void shouldThrowException_whenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            RewardCalculator.calculatePoints(-50);
        });
    }

}
