package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BestTimeToBuyAndSellStock1Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMaxProfit(int[] prices, int expected) {
        BestTimeToBuyAndSellStock1 bestTimeToBuyAndSellStock1 = new BestTimeToBuyAndSellStock1();
        assertEquals(expected, bestTimeToBuyAndSellStock1.maxProfit(prices));
    }

    private static Arguments[] provideTestCases() {
        return new Arguments[] {
            Arguments.of(new int[] {7, 1, 5, 3, 6, 4}, 5),
            Arguments.of(new int[] {7, 6, 4, 3, 1}, 0),
            Arguments.of(new int[] {1, 2, 3, 4, 5}, 4),
            Arguments.of(new int[] {5, 4, 3, 2, 1}, 0),
            Arguments.of(new int[] {1, 5, 3, 7, 2, 8}, 7),
            Arguments.of(new int[] {10, 22, 5, 75, 65, 80}, 75),
            Arguments.of(new int[] {100, 180, 260, 310, 40, 535, 695}, 655),
            Arguments.of(new int[] {}, 0),
            Arguments.of(new int[] {1}, 0),
            Arguments.of(new int[] {1, 1}, 0)
        };
    }
}