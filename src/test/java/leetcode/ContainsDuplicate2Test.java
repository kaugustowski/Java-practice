package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class ContainsDuplicate2Test {
    private final ContainsDuplicate2 solution = new ContainsDuplicate2();

    @ParameterizedTest(name = "nums={0}, k={1}, expected={2}")
    @MethodSource("testCases")
    void testContainsNearbyDuplicate(int[] nums, int k, boolean expected) {
        assertThat(solution.containsNearbyDuplicate(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "nums={0}, k={1}, expected={2}")
    @MethodSource("testCases")
    void testContainsNearbyDuplicate2(int[] nums, int k, boolean expected) {
        assertThat(solution.containsNearbyDuplicate2(nums, k)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                // From examples
                Arguments.of(new int[]{1, 2, 3, 1}, 3, true),
                Arguments.of(new int[]{1, 0, 1, 1}, 1, true),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3}, 2, false),
                
                // Edge cases
                Arguments.of(new int[]{}, 0, false),
                Arguments.of(new int[]{1}, 1, false),
                Arguments.of(new int[]{1, 1, 1, 1}, 1, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, false),
                Arguments.of(new int[]{1, 2, 3, 1}, 4, true),
                Arguments.of(new int[]{1, 2, 3, 1}, 0, false),
                
                // Additional test cases
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1}, 9, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1}, 8, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1}, 1, true)
        );
    }
}
