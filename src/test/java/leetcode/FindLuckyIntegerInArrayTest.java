package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class FindLuckyIntegerInArrayTest {
    private final FindLuckyIntegerInArray solution = new FindLuckyIntegerInArray();

    @ParameterizedTest
    @MethodSource("testCases")
    void testFindLucky(int[] arr, int expected) {
        assertEquals(expected, solution.findLucky(arr));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1
            Arguments.of(new int[]{2, 2, 3, 4}, 2),
            // Example 2
            Arguments.of(new int[]{1, 2, 2, 3, 3, 3}, 3),
            // Example 3
            Arguments.of(new int[]{2, 2, 2, 3, 3}, -1),
            // Additional test cases
            Arguments.of(new int[]{5}, -1),  // Single element, not lucky
            Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 7),  // All same elements, lucky
            Arguments.of(new int[]{1, 1, 1, 1}, -1),  // All ones, not lucky (1 appears 4 times)
            Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4}, 4)  // Multiple luckies, return largest
        );
    }

    @Test
    void testFindLuckyWithNullInput() {
        assertEquals(-1, solution.findLucky(null));
    }
}
