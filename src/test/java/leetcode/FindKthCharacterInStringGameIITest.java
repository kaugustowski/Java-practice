package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test cases for KthCharacterInStringGameII
 */
class FindKthCharacterInStringGameIITest {

    private final KthCharacterInStringGameII solution = new KthCharacterInStringGameII();

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic operations
            Arguments.of(2, new int[]{0}, 'a', "Single append operation (0) should double the string"),
            Arguments.of(2, new int[]{1}, 'b', "Single next character operation (1) should append next character"),
            
            // Multiple operations
            Arguments.of(4, new int[]{0, 1, 0}, 'b', "Multiple operations with operation 1 in the middle"),
            
            // Edge cases
            Arguments.of(1, new int[]{}, 'a', "No operations should return 'a' for k=1"),
            Arguments.of(2, new int[]{0, 1, 0, 1}, 'a', "Mixed operations with multiple operation 1s"),
            
            // Wrap around alphabet (26 operations of type 1)
            Arguments.of(1, 
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  // 10 operations
                         1, 1, 1, 1, 1, 1, 1, 1, 1, 1,  // 20 operations
                         1, 1, 1, 1, 1, 1},             // 26 operations (total 26)
                'a', 
                "After 26 operations of type 1, should wrap around to 'a'"
            ),
            
            // Large k value with operation 0
            Arguments.of(32, 
                new int[]{0, 0, 0, 0, 0},  // Each operation 0 doubles the string length
                'a',
                "Each operation (0) doubles the string length: 2^5 = 32 'a's"
            ),
            
            // Multiple operations with operation 1
            Arguments.of(4, 
                new int[]{1, 1},  // 'a' -> 'ab' -> 'abbc'
                'c',
                "Multiple operations with operation 1"
            ),
            
            // Test case from LeetCode
            Arguments.of(4, 
                new int[]{1, 0, 1},  // 'a' -> 'ab' -> 'abab' -> 'ababacbc'
                'b',
                "LeetCode test case: [1,0,1] with k=4"
            )
        );
    }

    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("testCases")
    void testKthCharacter(int k, int[] operations, char expected, String description) {
        assertThat(solution.kthCharacter(k, operations))
            .as(description)
            .isEqualTo(expected);
    }

}
