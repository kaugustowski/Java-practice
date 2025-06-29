package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @ParameterizedTest(name = "Test {index}: {0} should be {1}")
    @MethodSource("provideTestCases")
    void testIsValid(String input, boolean expected) {
        assertThat(solution.isValid(input))
            .as("Input: %s", input)
            .isEqualTo(expected);
    }

    @ParameterizedTest(name = "Test invalid input: {0}")
    @ValueSource(strings = {
        "(", "[", "{", "(", "((", "{{[",
        ")", "]", "}", ")", "))", "}}]"
    })
    void testInvalidInputs(String input) {
        assertThat(solution.isValid(input))
            .as("Input: %s should be invalid", input)
            .isFalse();
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Valid cases
            Arguments.of("", true),
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("{[]}", true),
            Arguments.of("([{}]){}", true),
            Arguments.of("(([]){})", true),
            
            // Invalid cases
            Arguments.of("(", false),
            Arguments.of(")", false),
            Arguments.of("(", false),
            Arguments.of("(]", false),
            Arguments.of("([)]", false),
            Arguments.of("([}}])", false),
            
            // Edge cases
            Arguments.of("[[[[[[[[[[[[[[[[[[[", false),
            Arguments.of("]]]]]]]]]]]]]]]]]]]", false),
            Arguments.of("[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]", true),
            
            // Mixed cases
            Arguments.of("([{}])", true),
            Arguments.of("([{)]}", false),
            Arguments.of("(){}}{}", false),
            Arguments.of("(((((()))))){}", true),
            Arguments.of("(((((())))))){}", false)
        );
    }
}
