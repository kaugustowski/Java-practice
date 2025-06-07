package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BestTimeToBuyAndSellStock2Test {

  @ParameterizedTest
  @MethodSource("provideTestCases")
  public void testMaxProfit(int[] prices, int expected) {
    BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
    assertEquals(expected, bestTimeToBuyAndSellStock2.maxProfit(prices));
  }

  private static Arguments[] provideTestCases() {
    return new Arguments[]{
        Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
        Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
        Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
        Arguments.of(new int[]{1, 5, 3, 7, 2, 8}, 14),
        Arguments.of(new int[]{10, 22, 5, 75, 65, 80}, 97),
        Arguments.of(new int[]{100, 180, 260, 310, 40, 535, 695}, 865),
        Arguments.of(new int[]{}, 0),
        Arguments.of(new int[]{1}, 0),
        Arguments.of(new int[]{1, 1}, 0)
    };
  }
}