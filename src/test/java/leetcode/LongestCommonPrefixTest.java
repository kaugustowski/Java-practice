package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonPrefixTest {
    private final LongestCommonPrefix solution = new LongestCommonPrefix();

    @ParameterizedTest
    @MethodSource("testCases")
    void testLongestCommonPrefix(String[] input, String expected) {
        // When
        String result = solution.longestCommonPrefix(input);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Common prefix exists
            arguments(
                new String[]{"flower", "flow", "flight"},
                "fl"
            ),
            
            // Test case 2: No common prefix
            arguments(
                new String[]{"dog", "racecar", "car"},
                ""
            ),
            
            // Test case 3: Empty array
            arguments(
                new String[]{},
                ""
            ),
            
            // Test case 4: Single string
            arguments(
                new String[]{"a"},
                "a"
            ),
            
            // Test case 5: Common prefix is the entire first string
            arguments(
                new String[]{"flower", "flower", "flower", "flower"},
                "flower"
            ),
            
            // Test case 6: Empty string in array
            arguments(
                new String[]{"", ""},
                ""
            ),
            
            // Test case 7: Very short strings
            arguments(
                new String[]{"a", "ab", "abc"},
                "a"
            ),
            
            // Test case 8: No common prefix (first character differs)
            arguments(
                new String[]{"car", "dog"},
                ""
            ),
            
            // Test case 9: Common prefix with single character
            arguments(
                new String[]{"cir", "car"},
                "c"
            )
        );
    }

    @Test
    void testWithLargeInput() {
        // Given
        String[] input = new String[200];
        String commonPrefix = "a".repeat(200);
        
        // Fill array with strings that share a common prefix
        for (int i = 0; i < 200; i++) {
            input[i] = commonPrefix + i;
        }
        
        // When
        String result = solution.longestCommonPrefix(input);
        
        // Then
        assertThat(result).isEqualTo(commonPrefix);
    }
}
