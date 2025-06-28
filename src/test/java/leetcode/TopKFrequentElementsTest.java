package leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TopKFrequentElementsTest {
    private final TopKFrequentElements solution = new TopKFrequentElements();

    @ParameterizedTest
    @MethodSource("testCases")
    void testTopKFrequent(int[] nums, int k, int[] expected) {
        int[] result = solution.topKFrequent(nums, k);
        Arrays.sort(result); // Sort for order-agnostic comparison
        Arrays.sort(expected);
        assertArrayEquals(expected, result,
            String.format("Expected top %d frequent elements: %s, but got: %s",
                k, Arrays.toString(expected), Arrays.toString(result)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Basic example
            Arguments.of(
                new int[]{1, 1, 1, 2, 2, 3},
                2,
                new int[]{1, 2}
            ),
            
            // Test case 2: Single element array
            Arguments.of(
                new int[]{1},
                1,
                new int[]{1}
            ),
            
            // Test case 3: All elements are the same
            Arguments.of(
                new int[]{4, 4, 4, 4},
                1,
                new int[]{4}
            ),
            
            // Test case 4: Negative numbers
            Arguments.of(
                new int[]{-1, -1, -2, -2, -2, -3, -3, -3, -3},
                2,
                new int[]{-3, -2}
            ),
            
            // Test case 5: k equals array length
            Arguments.of(
                new int[]{1, 2, 3, 1, 2, 1},
                3,
                new int[]{1, 2, 3}
            ),
            
            // Test case 6: Multiple elements with same frequency
            Arguments.of(
                new int[]{1, 2, 3, 1, 2, 4, 3, 5, 5, 6, 7, 7, 8, 2, 1, 3, 6},
                4,
                new int[]{1, 2, 3, 5}  // All appear 3 times
            )
        );
    }
}
