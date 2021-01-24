package codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountDivTest {

    CountDiv countDiv;

    @BeforeEach
    void setUp() {
        countDiv = new CountDiv();
    }

    @ParameterizedTest
    @MethodSource("inputValues")
    void solution(int A, int B, int K, int expected){
        int actual = countDiv.solution(A,B,K);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> inputValues(){
        return Stream.of(
                Arguments.of(6,11,2,3),
                Arguments.of(10,10,5,1),
                Arguments.of(10,10,12,0)
        );
    }
}