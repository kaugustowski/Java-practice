package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfSubsequencesThatSatisfyTheGivenSumConditionTest {

    private final NumberOfSubsequencesThatSatisfyTheGivenSumCondition solution = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();

    @ParameterizedTest(name = "Test {index}: nums={0}, target={1}, expected={2}")
    @MethodSource("testCases")
    void testNumSubseq(int[] nums, int target, int expected) {
        assertThat(solution.numSubseq(nums, target)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test cases from problem examples
            Arguments.of(new int[]{3, 5, 6, 7}, 9, 4),
            Arguments.of(new int[]{3, 3, 6, 8}, 10, 6),
            Arguments.of(new int[]{2, 3, 3, 4, 6, 7}, 12, 61),
            
            // Edge cases
            Arguments.of(new int[]{5}, 10, 1),          // Single valid element
            Arguments.of(new int[]{11}, 10, 0),         // Single invalid element
            Arguments.of(new int[]{1, 2, 3, 4}, 10, 15), // All elements valid (2^4 - 1 = 15)
            Arguments.of(new int[]{11, 12, 13, 14}, 10, 0), // No valid elements
            
            // Additional test cases
            Arguments.of(new int[]{1, 1, 1, 1}, 2, 15),  // All elements same, valid
            Arguments.of(new int[]{1, 2, 2, 3}, 3, 4),   // Duplicate elements, valid
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 0) // Target too small
        );
    }
}
