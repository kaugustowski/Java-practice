package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class RansomNoteTest {
    private final RansomNote solution = new RansomNote();

    @ParameterizedTest
    @MethodSource("testCases")
    void testCanConstruct(String ransomNote, String magazine, boolean expected) {
        assertEquals(expected, solution.canConstruct(ransomNote, magazine));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testCanConstruct2(String ransomNote, String magazine, boolean expected) {
        assertEquals(expected, solution.canConstruct2(ransomNote, magazine));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic cases
            Arguments.of("a", "b", false),
            Arguments.of("aa", "aab", true),
            
            // Edge cases
            Arguments.of("", "", true),  // Empty strings
            Arguments.of("a", "", false), // Empty magazine
            Arguments.of("", "a", true),  // Empty ransomNote
            
            // Same length cases
            Arguments.of("abc", "cba", true),
            Arguments.of("abc", "def", false),
            
            // Repeated characters
            Arguments.of("aabbcc", "aabbbcccdd", true),
            Arguments.of("aabbcc", "aabbc", false),
            
            // Case with all unique characters
            Arguments.of("abc", "defghijklmnopqrstuvwxyz", false),
            
            // Case with not enough characters
            Arguments.of("aa", "ab", false)
        );
    }

    @Test
    void testLargeInput() {
        // Test with large input to check performance
        String longString = "a".repeat(100000);
        assertTrue(solution.canConstruct("a", longString));
        assertFalse(solution.canConstruct(longString + "a", longString));
    }
}
