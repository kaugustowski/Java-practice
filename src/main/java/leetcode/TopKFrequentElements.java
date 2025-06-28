package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #347: Top K Frequent Elements
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return
 * the answer in any order.
 * <p>
 * Example 1: Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * <p>
 * Example 2: Input: nums = [1], k = 1 Output: [1]
 * <p>
 * Constraints: - 1 <= nums.length <= 10^5 - -10^4 <= nums[i] <= 10^4 - k is in the range [1, the
 * number of unique elements in the array]. - It is guaranteed that the answer is unique.
 */
public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    List<Integer>[] freq = new List[nums.length + 1];

    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }

    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      freq[entry.getValue()].add(entry.getKey());
    }

    int[] res = new int[k];
    int index = 0;
    for (int i = freq.length - 1; i > 0 && index < k; i--) {
      for (int n : freq[i]) {
        res[index++] = n;
        if (index == k) {
          return res;
        }
      }
    }
    return res;
  }
}
