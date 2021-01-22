package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DecodeXORedArrayTest {

    DecodeXORedArray decodeXORedArray;

    @BeforeEach
    void setUp() {
        decodeXORedArray = new DecodeXORedArray();
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void solution(int[] encoded, int first, int [] expected){
        int [] actual = decodeXORedArray.decode(encoded, first);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, 1, new int[]{1,0,2,1}),
                Arguments.of(new int[]{6,2,7,3}, 4, new int[]{4,2,0,7,4}),
                Arguments.of(new int[]{4,5,7,8,2,3}, 3, new int[]{3, 7, 2, 5, 13, 15, 12})
        );
    }

}