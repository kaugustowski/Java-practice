package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {
    private final CoinChange solution = new CoinChange();

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic test cases
            Arguments.of(new int[]{1, 2, 5}, 11, 3),
            Arguments.of(new int[]{2}, 3, -1),
            Arguments.of(new int[]{1}, 0, 0),
            
            // Edge cases
            Arguments.of(new int[]{1}, 1, 1),
            Arguments.of(new int[]{1}, 2, 2),
            Arguments.of(new int[]{2}, 1, -1),
            
            // More complex cases
            Arguments.of(new int[]{1, 3, 4, 5}, 7, 2),
            Arguments.of(new int[]{186, 419, 83, 408}, 6249, 20),
            Arguments.of(new int[]{1, 2, 5}, 100, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCoinChange(int[] coins, int amount, int expected) {
        assertEquals(expected, solution.coinChange(coins, amount));
    }
}
