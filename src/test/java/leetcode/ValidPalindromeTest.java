package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {
    private final ValidPalindrome solution = new ValidPalindrome();

    @ParameterizedTest
    @MethodSource("testCases")
    void testIsPalindrome(String input, boolean expected) {
        // When
        boolean result = solution.isPalindrome(input);
        
        // Then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1 from LeetCode
            Arguments.of("A man, a plan, a canal: Panama", true),
            
            // Example 2 from LeetCode
            Arguments.of("race a car", false),
            
            // Example 3 from LeetCode
            Arguments.of(" ", true),
            
            // Additional test cases
            Arguments.of("", true),
            Arguments.of("a", true),
            Arguments.of("0P", false),
            Arguments.of("Able was I, I saw elba", true),
            Arguments.of("No 'x' in Nixon", true),
            Arguments.of("Able was I, I saw elba!", true),
            Arguments.of("race a car!", false),
            Arguments.of("ab_a", true),
            Arguments.of("a.b,.", false),
            Arguments.of("A man, a plan, a canal -- Panama", true),
            Arguments.of("Was it a car or a cat I saw?", true),
            Arguments.of("No 'x' in 'Nixon'", true),
            Arguments.of("Able was I ere I saw Elba", true)
        );
    }

    @Test
    void testNullInput() {
        // When
        boolean result = solution.isPalindrome(null);
        
        // Then
        assertThat(result).isFalse();
    }
}
