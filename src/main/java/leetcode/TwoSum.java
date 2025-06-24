package leetcode;

import java.util.HashMap;

/**
 * LeetCode #1: Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target. You may assume that each input would have exactly one solution, and
 * you may not use the same element twice. You can return the answer in any order.
 * <p>
 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 * <p>
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> indexesByValues = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      var missingValue = target - nums[i];
      if (indexesByValues.containsKey(missingValue)) {
        return new int[]{indexesByValues.get(missingValue), i};
      } else {
        indexesByValues.put(nums[i], i);
      }

    }

    return new int[0];
  }
}
