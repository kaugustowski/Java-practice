package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SubsequenceLargestSumTest {
    private final SubsequenceLargestSum solution = new SubsequenceLargestSum();

    @ParameterizedTest
    @MethodSource("testCases")
    void testMaxSubsequence(int[] nums, int k, int[] expected) {
        int[] result = solution.maxSubsequence(nums, k);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testMaxSubsequence2(int[] nums, int k, int[] expected) {
        int[] result = solution.maxSubsequence2(nums, k);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Example from LeetCode
            Arguments.of(new int[]{2,1,3,3}, 2, new int[]{3,3}),
            
            // Test case 2: Another example from LeetCode
            Arguments.of(new int[]{-1,-2,3,4}, 3, new int[]{-1,3,4}),
            
            // Test case 3: All positive numbers
            Arguments.of(new int[]{5,7,2,9,4,3}, 3, new int[]{5,7,9}),
            
            // Test case 4: All negative numbers
            Arguments.of(new int[]{-5,-2,-1,-4,-3}, 2, new int[]{-2,-1}),
            
            // Test case 5: Single element array
            Arguments.of(new int[]{10}, 1, new int[]{10}),
            
            // Test case 6: k equals array length
            Arguments.of(new int[]{1,2,3,4,5}, 5, new int[]{1,2,3,4,5}),
            
            // Test case 7: Duplicate values
            Arguments.of(new int[]{1,1,1,2,2,3}, 4, new int[]{1,2,2,3}),
            
            // Test case 8: Mixed positive and negative numbers
            Arguments.of(new int[]{-1,4,-2,5,-3,6}, 3, new int[]{4,5,6}),
            
            // Test case 9: All zeros
            Arguments.of(new int[]{0,0,0,0,0}, 3, new int[]{0,0,0}),
            
            // Test case 10: Large numbers
            Arguments.of(new int[]{1000000,-1000000,500000,200000}, 2, new int[]{1000000,500000})
        );
    }

}
