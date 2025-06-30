package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {
    private final HouseRobber solution = new HouseRobber();

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, 4),
            Arguments.of(new int[]{2, 7, 9, 3, 1}, 12),
            Arguments.of(new int[]{5}, 5),
            Arguments.of(new int[]{2, 1}, 2),
            Arguments.of(new int[]{}, 0),
            Arguments.of(new int[]{2, 1, 1, 2}, 4),
            Arguments.of(new int[]{1, 3, 1, 3, 100}, 103)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testRob(int[] nums, int expected) {
        assertEquals(expected, solution.rob(nums));
    }
}
