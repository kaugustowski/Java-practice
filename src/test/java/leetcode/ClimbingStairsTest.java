package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ClimbingStairsTest {
    private final ClimbingStairs solution = new ClimbingStairs();

    @ParameterizedTest
    @MethodSource("testCases")
    void testClimbStairs(int n, int expected) {
        int result = solution.climbStairs(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testClimbStairs2(int n, int expected) {
        int result = solution.climbStairs2(n);
        assertEquals(expected, result);
    }


    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Base cases
            Arguments.of(1, 1),  // Only one way: 1 step
            Arguments.of(2, 2),  // 1+1 or 2
            
            // Example cases
            Arguments.of(3, 3),  // 1+1+1, 1+2, 2+1
            Arguments.of(4, 5),  // 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2
            
            // Edge cases
            Arguments.of(5, 8),  // 8 distinct ways
            Arguments.of(10, 89), // Larger input
            
            // Upper constraint
            Arguments.of(45, 1836311903)  // Maximum input value
        );
    }
}
