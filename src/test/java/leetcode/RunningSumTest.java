package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RunningSumTest {

    JewelsAndStones jewelsAndStones;

    @BeforeEach
    void setUp() {
        jewelsAndStones = new JewelsAndStones();
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void solution(String jewels, String stones, int expected){
        int actual = jewelsAndStones.numJewelsInStones(jewels, stones);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("aA", "aAAbbbb", 3),
                Arguments.of("z", "ZZ", 0),
                Arguments.of("abcDEF", "aabbbaaccDDDdddeeeEffFzxcZXC", 15)
        );
    }


}