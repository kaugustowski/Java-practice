package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {
    private final MinCostClimbingStairs solution = new MinCostClimbingStairs();

    @ParameterizedTest
    @MethodSource("testCases")
    void testMinCostClimbingStairs(int[] cost, int expected) {
        int result = solution.minCostClimbingStairs(cost);
        assertEquals(expected, result);
    }


    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1 from problem description
            Arguments.of(new int[]{10, 15, 20}, 15),
            
            // Example 2 from problem description
            Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6),
            
            // Smallest possible input (2 steps)
            Arguments.of(new int[]{1, 2}, 1),
            
            // All same cost
            Arguments.of(new int[]{5, 5, 5, 5}, 10),
            
            // Increasing cost
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6),
            
            // Decreasing cost
            Arguments.of(new int[]{5, 4, 3, 2, 1}, 4),
            
            // Alternating high and low costs
            Arguments.of(new int[]{10, 1, 10, 1, 10}, 2),
            
            // Large input (max constraint)
            Arguments.of(new int[1000], 0)
        );
    }

}
