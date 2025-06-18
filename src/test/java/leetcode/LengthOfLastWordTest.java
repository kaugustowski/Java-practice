package leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LengthOfLastWordTest {

  private final LengthOfLastWord solution = new LengthOfLastWord();

  @ParameterizedTest(name = "should return {1} when input is \"{0}\"")
  @MethodSource("testCases")
  void lengthOfLastWord_shouldReturnCorrectLength(String input, int expected) {
    int result = solution.lengthOfLastWord(input);

    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("Hello World", 5),
        arguments("   fly me   to   the moon      ", 4),
        arguments("luffy is still   joyboy             ", 6),
        arguments("a", 1),
        arguments("    a    ", 1),
        arguments("word", 4),
        arguments("    word    ", 4),
        arguments("multiple    spaces   between", 7),
        arguments("test test test", 4),
        arguments("Hello World! 123", 3),
        arguments("EndsWithNumber123 456", 3),
        arguments("a " + "b".repeat(100), 100)
    );
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {" ", "    ", "\t", "\n", "\r\n"})
  void lengthOfLastWord_shouldHandleEmptyOrBlankInputs(String input) {
    int result = solution.lengthOfLastWord(input);

    assertThat(result).isZero();
  }

  @Test
  void lengthOfLastWord_shouldHandleVeryLongInput() {
    String longInput = "a".repeat(10_000);

    int result = solution.lengthOfLastWord(longInput);

    assertThat(result).isEqualTo(10_000);
  }
}
