package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveElementsTest {

    private final RemoveElements solution = new RemoveElements();

    @ParameterizedTest(name = "nums={0}, val={1}, expectedK={2}, expectedNums={3}")
    @MethodSource("testCases")
    void removeElement_shouldRemoveElements(int[] nums, int val, int expectedK, int[] expectedNums) {
        // Act
        int result = solution.removeElement(nums, val);

        // Assert
        assertThat(result).isEqualTo(expectedK);
        
        // Verify the length matches expected
        assertThat(result).isEqualTo(expectedNums.length);
        
        // Sort and compare the first k elements with expected values
        if (expectedNums.length > 0) {
            Arrays.sort(nums, 0, result);
            int[] actualNums = Arrays.copyOfRange(nums, 0, result);
            Arrays.sort(expectedNums);
            assertThat(actualNums).isEqualTo(expectedNums);
        }
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Remove single occurrence from middle
            Arguments.of(
                new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}
            ),
            // Test case 2: Multiple occurrences to remove
            Arguments.of(
                new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4}
            ),
            // Test case 3: Remove all elements
            Arguments.of(
                new int[]{1, 1, 1, 1}, 1, 0, new int[]{}
            ),
            // Test case 4: No elements to remove
            Arguments.of(
                new int[]{4, 5, 6}, 7, 3, new int[]{4, 5, 6}
            ),
            // Test case 5: Empty array
            Arguments.of(
                new int[]{}, 1, 0, new int[]{}
            ),
            // Test case 6: Remove from beginning and end
            Arguments.of(
                new int[]{5, 2, 3, 5, 6, 5}, 5, 3, new int[]{2, 3, 6}
            )
        );
    }

    
    @Test
    void removeElement_shouldHandleNullInput() {
        // Arrange
        int[] nums = null;
        int val = 5;
        
        // Act & Assert
        assertThat(solution.removeElement(nums, val)).isZero();
    }
}
