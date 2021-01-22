package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MinimumDeciBinaryNumbersTest {

    MinimumDeciBinaryNumbers minimumDeciBinaryNumbers;

    @BeforeEach
    void setUp() {
        minimumDeciBinaryNumbers = new MinimumDeciBinaryNumbers();
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void solution(String input, int expected){
        int actual = minimumDeciBinaryNumbers.minPartitions(input);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("32", 3),
                Arguments.of("82734", 8),
                Arguments.of("27346209830709182346", 9)
        );
    }

}