package leetcode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. You
 * want to maximize your profit by choosing a single day to buy one stock and choosing a different
 * day in the future to sell that stock. Return the maximum profit you can achieve from this
 * transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5
 * (price = 6), profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed
 * because you must buy before you sell.
 * <p>
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions are done and
 * the
 * <p>
 * max profit = 0.
 **/

public class BestTimeToBuyAndSellStock1 {

  public int maxProfit(int[] prices) {

    if (prices.length == 0) {
      return 0;
    }

    int minPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }

    return maxProfit;
  }
}
