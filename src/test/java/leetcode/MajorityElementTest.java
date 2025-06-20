package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @ParameterizedTest(name = "Test {index} => nums={0}, expected={1}")
    @MethodSource("testCases")
    @DisplayName("Test majorityElement (Boyer-Moore)")
    void testMajorityElement(int[] nums, int expected) {
        assertEquals(expected, MajorityElement.majorityElement(nums));
    }

    @ParameterizedTest(name = "Test {index} => nums={0}, expected={1}")
    @MethodSource("testCases")
    @DisplayName("Test majorityElementWithMap (HashMap)")
    void testMajorityElementWithMap(int[] nums, int expected) {
        assertEquals(expected, MajorityElement.majorityElementWithMap(nums));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic test cases
            Arguments.of(new int[]{3, 2, 3}, 3),
            Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
            
            // Edge cases
            Arguments.of(new int[]{1}, 1),  // Single element
            Arguments.of(new int[]{5, 5, 5, 5}, 5),  // All elements same
            Arguments.of(new int[]{-1, -1, -1, 2, 3, -1, -1}, -1),  // Negative numbers
            
            // Larger test cases
            Arguments.of(new int[]{1, 1, 1, 1, 2, 3, 4, 1}, 1),  // Majority at end
            Arguments.of(new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7}, 7)  // Complex case
        );
    }
}
