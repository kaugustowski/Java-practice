package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FindFirstOccurrenceInStringTest {
    private final FindFirstOccurrenceInString solution = new FindFirstOccurrenceInString();

    @ParameterizedTest
    @MethodSource("testCases")
    void testStrStr(String haystack, String needle, int expected) {
        // When
        int result = solution.strStr(haystack, needle);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testStrStr2(String haystack, String needle, int expected) {
        // When
        int result = solution.strStr2(haystack, needle);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1
            Arguments.of("sadbutsad", "sad", 0),

            // Example 2
            Arguments.of("leetcode", "leeto", -1),

            // Example 3
            Arguments.of("mississippi", "sipp", 6),

            // Single character match
            Arguments.of("hello", "ll", 2),

            // No match
            Arguments.of("abc", "d", -1),

            // Needle as last character
            Arguments.of("abc", "c", 2),

            // Needle same as haystack
            Arguments.of("same", "same", 0),

            // Multiple occurrences
            Arguments.of("mississippi", "issip", 4),

            // Single character haystack and needle match
            Arguments.of("a", "a", 0)
        );
    }
}
