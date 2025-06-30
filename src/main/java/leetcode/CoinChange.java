package leetcode;

import java.util.Arrays;

/**
 * 322. Coin Change
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer
 * amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

  /**
   * Calculates the fewest number of coins needed to make up the given amount.
   *
   * @param coins  Array of coin denominations
   * @param amount The target amount
   * @return The minimum number of coins needed, or -1 if it's not possible
   */
  public int coinChange(int[] coins, int amount) {

    int[] memo = new int[amount + 1];

    Arrays.fill(memo, amount + 1);

    memo[0] = 0;

    for (int j = 1; j <= amount; j++) {
      for (int coin : coins) {
        if (coin <= j) {
          memo[j] = Math.min(memo[j], memo[j - coin] + 1);
        }
      }
    }

    return memo[amount] > amount ? -1 : memo[amount];
  }
}
