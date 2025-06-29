package leetcode;

import java.util.Arrays;

/**
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition
 * <p>
 * You are given an array of integers nums and an integer target.
 * <p>
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum
 * element on it is less or equal to target. Since the answer may be too large, return it modulo
 * 10^9 + 7.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no
 * elements without changing the order of the remaining elements.
 * <p>
 * Example 1: Input: nums = [3,5,6,7], target = 9 Output: 4 Explanation: There are 4 subsequences
 * that satisfy the condition: - [3] -> Min value + max value = 3 + 3 = 6 < 9 - [3,5] -> Min value +
 * max value = 3 + 5 = 8 < 9 - [3,5,6] -> Min value + max value = 3 + 6 = 9 <= 9 - [3,6] -> Min
 * value + max value = 3 + 6 = 9 <= 9
 * <p>
 * Example 2: Input: nums = [3,3,6,8], target = 10 Output: 6
 * <p>
 * Example 3: Input: nums = [2,3,3,4,6,7], target = 12 Output: 61
 * <p>
 * Constraints: 1 <= nums.length <= 10^5 1 <= nums[i] <= 10^6 1 <= target <= 10^6
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

  private static final int MODULO = 1_000_000_007;

  public int numSubseq(int[] nums, int target) {
    Arrays.sort(nums);

    int n = nums.length;
    int[] power = new int[n];
    power[0] = 1;
    for (int i = 1; i < n; i++) {
      power[i] = (power[i - 1] * 2) % MODULO;
    }

    int left = 0;
    int right = n - 1;
    int result = 0;

    while (left <= right) {
      if (nums[left] + nums[right] > target) {
        right--;
      } else {
        result = (result + power[right - left]) % MODULO;
        left++;
      }
    }

    return result;
  }
}
