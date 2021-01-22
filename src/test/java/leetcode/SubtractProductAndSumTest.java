package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractProductAndSumTest {

    SubtractProductAndSum subtractProductAndSum;

    @BeforeEach
    void setUp() {
        subtractProductAndSum = new SubtractProductAndSum();
    }

    @ParameterizedTest
    @MethodSource("provideInts")
    void solution(int input, int expected){
        int actual = subtractProductAndSum.subtractProductAndSum(input);
        assertThat(actual).isEqualTo(expected);
    }


    private static Stream<Arguments> provideInts() {
        return Stream.of(
                Arguments.of(234,15),
                Arguments.of(4421,21),
                Arguments.of(541,10)
        );
    }

}