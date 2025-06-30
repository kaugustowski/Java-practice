package leetcode;

/**
 * 213. House Robber II
 * <p>
 * You are a professional robber planning to rob houses arranged in a circle. Each house has a
 * certain amount of money stashed. All houses at this place are arranged in a circle. That means
 * the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security
 * system connected, and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {


  public int rob(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(
        robHelper(nums, 0, nums.length - 2),
        robHelper(nums, 1, nums.length - 1)
    );
  }

  private int robHelper(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }

    int n = end - start + 1;
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
    }

    return dp[n - 1];
  }
}
