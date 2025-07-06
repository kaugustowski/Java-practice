package leetcode;

import java.util.HashMap;

/**
 * 1865. Finding Pairs With a Certain Sum
 * <p>
 * You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure
 * that supports queries of two types: 1. Add a positive integer to an element of nums2. 2. Count
 * the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i <
 * nums1.length and 0 <= j < nums2.length).
 * <p>
 * Implement the FindSumPairs class: - FindSumPairs(int[] nums1, int[] nums2) Initializes the
 * FindSumPairs object with two integer arrays nums1 and nums2. - void add(int index, int val) Adds
 * val to nums2[index] (0-indexed). - int count(int tot) Returns the number of pairs (i, j) such
 * that nums1[i] + nums2[j] == tot.
 */
public class FindSumPairs {

  HashMap<Integer, Integer> freqs = new HashMap<>();
  int[] first, second;

  public FindSumPairs(int[] nums1, int[] nums2) {
    this.first = nums1;
    this.second = nums2;

    for (var num : nums2) {
      freqs.put(num, freqs.getOrDefault(num, 0) + 1);
    }

  }

  public void add(int index, int val) {
    var decrementKey = second[index];
    var incrementKey = second[index] + val;

    second[index] += val;

    freqs.put(decrementKey, freqs.get(decrementKey) - 1);
    freqs.put(incrementKey, freqs.getOrDefault(incrementKey, 0) + 1);
  }

  public int count(int tot) {

    var result = 0;

    for (int num : first) {
      result += freqs.getOrDefault(tot - num, 0);
    }

    return result;
  }
}
