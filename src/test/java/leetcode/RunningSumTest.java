package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RunningSumTest {

    RunningSum subtractProductAndSum;

    @BeforeEach
    void setUp() {
        subtractProductAndSum = new RunningSum();
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void solution(int [] input, int [] expected){
        int [] actual = subtractProductAndSum.runningSum(input);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,3,6,10}),
                Arguments.of(new int[]{1,1,1,1,1}, new int[]{1,2,3,4,5}),
                Arguments.of(new int[]{3,1,2,10,1}, new int[]{3,4,6,16,17})
        );
    }


}