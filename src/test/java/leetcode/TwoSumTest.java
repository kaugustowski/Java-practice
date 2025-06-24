package leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumTest {
    private final TwoSum solution = new TwoSum();

    @ParameterizedTest
    @MethodSource("testCases")
    void testTwoSum(int[] nums, int target, int[] expected) {
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(expected, result, 
            String.format("Expected indices %s for target %d in array %s, but got %s",
                arrayToString(expected), target, arrayToString(nums), arrayToString(result)));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Basic example
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            
            // Test case 2: Numbers not at beginning
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            
            // Test case 3: Duplicate numbers
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            
            // Test case 4: Negative numbers
            Arguments.of(new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}),
            
            // Test case 5: Multiple possible solutions (first occurrence should be returned)
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 9, new int[]{3, 4}),
            
            // Test case 6: Large numbers
            Arguments.of(new int[]{1000000000, 2000000000, -1000000000, -2000000000}, 0, new int[]{0, 2})
        );
    }

    private String arrayToString(int[] arr) {
        if (arr == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
