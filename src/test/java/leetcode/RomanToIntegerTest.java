package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RomanToIntegerTest {
  private final RomanToInteger solution = new RomanToInteger();

  @ParameterizedTest
  @MethodSource("testCases")
  void testRomanToInt(String input, int expected) {
    // When
    int result = solution.romanToInt(input);

    // Then
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        // Example 1
        Arguments.of("III", 3),

        // Example 2
        Arguments.of("LVIII", 58),

        // Example 3
        Arguments.of("MCMXCIV", 1994),

        // Additional test cases
        Arguments.of("I", 1),
        Arguments.of("IV", 4),
        Arguments.of("IX", 9),
        Arguments.of("XL", 40),
        Arguments.of("XC", 90),
        Arguments.of("CD", 400),
        Arguments.of("CM", 900),
        Arguments.of("MCMXC", 1990),
        Arguments.of("MMMCMXCIX", 3999),
        Arguments.of("DCXXI", 621),
        Arguments.of("MCMXCII", 1992),
        Arguments.of("XLVII", 47),
        Arguments.of("XCIX", 99)
    );
  }

  @ParameterizedTest
  @NullAndEmptySource
  void testZeroCornerCases(String input) {
    assertThat(solution.romanToInt(input)).isZero();
  }

}