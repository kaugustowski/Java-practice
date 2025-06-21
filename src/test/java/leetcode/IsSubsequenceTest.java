package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class IsSubsequenceTest {
    private final IsSubsequence solution = new IsSubsequence();

    @ParameterizedTest
    @MethodSource("testCases")
    void testIsSubsequence(String s, String t, boolean expected) {
        // When
        boolean result = solution.isSubsequence(s, t);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: s is empty (should always return true)
            Arguments.of("", "", true),
            Arguments.of("", "abc", true),
            
            // Test case 2: t is empty but s is not
            Arguments.of("a", "", false),
            
            // Test case 3: s is a single character present in t
            Arguments.of("a", "abc", true),
            
            // Test case 4: s is a single character not in t
            Arguments.of("d", "abc", false),
            
            // Test case 5: s is a subsequence at the beginning
            Arguments.of("abc", "abcdef", true),
            
            // Test case 6: s is a subsequence in the middle
            Arguments.of("bde", "abcdef", true),
            
            // Test case 7: s is a subsequence at the end
            Arguments.of("def", "abcdef", true),
            
            // Test case 8: s is not a subsequence (wrong order)
            Arguments.of("bda", "abcdef", false),
            
            // Test case 9: s has duplicate characters
            Arguments.of("aab", "aaab", true),
            
            // Test case 10: s is equal to t
            Arguments.of("abc", "abc", true),
            
            // Test case 11: s is longer than t
            Arguments.of("abcd", "abc", false)
        );
    }

    @Test
    void testWithLargeInput() {
        // Given
        String s = "ace";
        String t = "a".repeat(10000) + "b".repeat(10000) + "c".repeat(10000) + "d".repeat(10000) + "e".repeat(10000);
        
        // When
        boolean result = solution.isSubsequence(s, t);
        
        // Then
        assertThat(result).isTrue();
    }
}
