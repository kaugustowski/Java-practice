package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum
 * <p>
 * You are given an integer array nums and an integer k. You want to find a subsequence of nums of
 * length k that has the largest sum.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements
 * without changing the order of the remaining elements.
 * <p>
 * Note: - The subsequence should be returned as an array of k integers. - The order of the elements
 * in the returned array should be the same as their order in the original array. - It is guaranteed
 * that the answer is unique.
 * <p>
 * Example 1: Input: nums = [2,1,3,3], k = 2 Output: [3,3] Explanation: The subsequence has the
 * largest sum of 3 + 3 = 6.
 * <p>
 * Example 2: Input: nums = [-1,-2,3,4], k = 3 Output: [-1,3,4] Explanation: The subsequence has the
 * largest sum of -1 + 3 + 4 = 6.
 * <p>
 * Constraints: - 1 <= nums.length <= 1000 - -10^5 <= nums[i] <= 10^5 - 1 <= k <= nums.length
 */
public class SubsequenceLargestSum {


  public int[] maxSubsequence(int[] nums, int k) {

    var result = new int[k];

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> a[0]).reversed());

    for (int i = 0; i < nums.length; i++) {
      priorityQueue.add(new int[]{nums[i], i});
    }

    int[][] topK = new int[k][2];
    for (int i = 0; i < k; i++) {
      topK[i] = priorityQueue.poll();
    }

    Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

    for (int i = 0; i < k; i++) {
      result[i] = topK[i][0];
    }

    return result;
  }

  public int[] maxSubsequence2(int[] nums, int k) {
    int[][] withIndices = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      withIndices[i][0] = nums[i];
      withIndices[i][1] = i;
    }

    Arrays.sort(withIndices, (a, b) -> b[0] - a[0]);

    int[][] topK = Arrays.copyOf(withIndices, k);
    Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = topK[i][0];
    }

    return result;
  }
}
