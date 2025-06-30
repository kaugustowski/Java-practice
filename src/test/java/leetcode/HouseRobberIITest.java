package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class HouseRobberIITest {
    private final HouseRobberII solution = new HouseRobberII();

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic test cases
            Arguments.of(new int[]{2, 3, 2}, 3),
            Arguments.of(new int[]{1, 2, 3, 1}, 4),
            
            // Edge cases
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{1, 2}, 2),
            Arguments.of(new int[]{1, 2, 3}, 3),
            
            // More complex cases
            Arguments.of(new int[]{200, 3, 140, 20, 10}, 340),
            Arguments.of(new int[]{1, 3, 1, 3, 100}, 103)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRob(int[] nums, int expected) {
        assertEquals(expected, solution.rob(nums));
    }
}
