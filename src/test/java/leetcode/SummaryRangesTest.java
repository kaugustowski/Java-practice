package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRangesTest {

    private final SummaryRanges solution = new SummaryRanges();

    @ParameterizedTest(name = "Test {index}: nums={0}, expected={1}")
    @MethodSource("testCases")
    void testSummaryRanges(int[] nums, List<String> expected) {
        assertThat(solution.summaryRanges(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test cases from problem examples
            Arguments.of(
                new int[]{0, 1, 2, 4, 5, 7},
                List.of("0->2", "4->5", "7")
            ),
            Arguments.of(
                new int[]{0, 2, 3, 4, 6, 8, 9},
                List.of("0", "2->4", "6", "8->9")
            ),
            
            // Edge cases
            Arguments.of(
                new int[]{},
                List.of()
            ),
            Arguments.of(
                new int[]{-1},
                List.of("-1")
            ),
            Arguments.of(
                new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE},
                List.of("" + Integer.MIN_VALUE, "" + Integer.MAX_VALUE)
            ),
            
            // Additional test cases
            Arguments.of(
                new int[]{1, 2, 3, 5, 6, 8, 10, 11, 12},
                List.of("1->3", "5->6", "8", "10->12")
            ),
            Arguments.of(
                new int[]{-5, -4, -3, -1, 0, 1, 3, 4, 5, 7},
                List.of("-5->-3", "-1->1", "3->5", "7")
            ),
            Arguments.of(
                new int[]{1, 3, 5, 7, 9},
                List.of("1", "3", "5", "7", "9")
            ),
            Arguments.of(
                new int[]{-3, -2, -1, 0, 1, 2, 3},
                List.of("-3->3")
            )
        );
    }
}
