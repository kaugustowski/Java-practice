package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class WordPatternTest {
    private final WordPattern solution = new WordPattern();

    @ParameterizedTest
    @MethodSource("testCases")
    void testWordPattern(String pattern, String s, boolean expected) {
        boolean result = solution.wordPattern(pattern, s);
        assertEquals(expected, result, 
            String.format("Failed for pattern: '%s' and string: '%s'", pattern, s));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Basic test cases
            Arguments.of("abba", "dog cat cat dog", true),
            Arguments.of("abba", "dog cat cat fish", false),
            Arguments.of("aaaa", "dog cat cat dog", false),
            
            // Edge cases
            Arguments.of("a", "dog", true),
            Arguments.of("aaa", "dog dog dog", true),
            Arguments.of("abc", "dog cat dog", false),  // 'a' and 'c' map to same word
            Arguments.of("abba", "dog dog dog dog", false),  // All words same but pattern requires different
            
            // Different lengths
            Arguments.of("abba", "dog cat cat", false),  // Different lengths
            Arguments.of("abc", "dog cat", false),       // Different lengths
            
            // Empty cases
            Arguments.of("", "", true),                 // Both empty
            Arguments.of("a", "", false),               // Empty string
            Arguments.of("", "dog", false),             // Empty pattern
            
            // Complex cases
            Arguments.of("abcba", "dog cat fish cat dog", true),
            Arguments.of("abcba", "dog cat fish cat fish", false)
        );
    }
}
