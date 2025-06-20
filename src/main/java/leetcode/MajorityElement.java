package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element. The majority element is the element
 * that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in
 * the array.
 */
public class MajorityElement {

  public static int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;
    
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }
    
    return candidate;
  }

  public static int majorityElementWithMap(int[] nums) {
    var topNumber = nums[0];
    var topCount = 0;
    Map<Integer, Integer> countMap = new HashMap<>();

    for (int num : nums) {
      if (countMap.containsKey(num)) {
        var currentCount = countMap.get(num) + 1;
        countMap.replace(num, currentCount);
        if (currentCount > topCount) {
          topCount = currentCount;
          topNumber = num;
        }
      } else {
        countMap.put(num, 1);
      }
    }

    return topNumber;
  }
}