package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidAnagramTest {

    private final ValidAnagram solution = new ValidAnagram();

    @ParameterizedTest(name = "Test {index}: s={0}, t={1}, expected={2}")
    @MethodSource("provideTestCases")
    void testIsAnagram(String s, String t, boolean expected) {
        assertThat(solution.isAnagram(s, t))
            .as("Input: s='%s', t='%s'", s, t)
            .isEqualTo(expected);
    }

    @Test
    void testWithDifferentLengths() {
        assertThat(solution.isAnagram("anagram", "nagaram1")).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        "a",
        "aabbcc",
        "abcdefghijklmnopqrstuvwxyz"
    })
    void testWithSameStrings(String input) {
        assertThat(solution.isAnagram(input, input)).isTrue();
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Basic test cases
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("rat", "car", false),
            
            // Edge cases
            Arguments.of("", "", true),
            Arguments.of("a", "a", true),
            Arguments.of("a", "b", false),
            
            // Same characters different counts
            Arguments.of("aab", "abb", false),
            
            // Case with special characters (though problem states lowercase English letters only)
            
            // Long strings
            Arguments.of("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", true),
            
            // Repeated characters
            Arguments.of("aabbcc", "abcabc", true),
            Arguments.of("aabbcc", "aabbc", false),
            
            // Different lengths (handled by method, but good to test)
            Arguments.of("abc", "abcd", false),
            Arguments.of("abcd", "abc", false)
        );
    }
}
