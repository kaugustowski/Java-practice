package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DecompressEncodedListTest {

    DecompressEncodedList decompressEncodedList;

    @BeforeEach
    void setUp() {
        decompressEncodedList = new DecompressEncodedList();
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void solution(int [] nums, int [] expected){
        int [] actual = decompressEncodedList.decompressRLElist(nums);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4}, new int[]{2,4,4,4}),
                Arguments.of(new int[]{1,1,2,3}, new int[]{1,3,3}),
                Arguments.of(new int[]{5,2,2,5,3,2,2,1}, new int[]{2,2,2,2,2,5,5,2,2,2,1,1}),
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[]{2,4,4,4,6,6,6,6,6})
        );
    }

}
