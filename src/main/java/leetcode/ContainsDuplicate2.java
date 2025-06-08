package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 219. Contains Duplicate II Given an integer array nums and an integer k, return true if there are
 * two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3 Output: true Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1 Output: true Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 * <p>
 */

public class ContainsDuplicate2 {

  public boolean containsNearbyDuplicate(int[] nums, int k) {

    HashMap<Integer, List<Integer>> indexesByValues = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!indexesByValues.containsKey(nums[i])) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        indexesByValues.put(nums[i], list);
      } else {
        indexesByValues.get(nums[i]).add(i);
      }
    }

    for (List<Integer> indexes : indexesByValues.values()) {
      for (int j = 0; j < indexes.size() - 1; j++) {
        if (indexes.get(j + 1) - indexes.get(j) <= k) {
          return true;
        }
      }
    }

    return false;
  }


  public boolean containsNearbyDuplicate2(int[] nums, int k) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
        return true;
      }
      map.put(nums[i], i);
    }

    return false;
  }

}
