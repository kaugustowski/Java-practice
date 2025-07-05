package leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * 1394. Find Lucky Integer in an Array
 * <p>
 * Given an array of integers arr, a lucky integer is an integer that has a frequency in the array
 * equal to its value. Return the largest lucky integer in the array. If there is no lucky integer,
 * return -1.
 * <p>
 * Example 1: Input: arr = [2,2,3,4] Output: 2 Explanation: The only lucky number in the array is 2
 * because frequency[2] == 2.
 * <p>
 * Example 2: Input: arr = [1,2,2,3,3,3] Output: 3 Explanation: 1, 2 and 3 are all lucky numbers,
 * return the largest of them.
 * <p>
 * Example 3: Input: arr = [2,2,2,3,3] Output: -1 Explanation: There are no lucky numbers in the
 * array.
 */
public class FindLuckyIntegerInArray {


  public int findLucky(int[] arr) {

    var result = -1;
    HashMap<Integer, Integer> count = new HashMap<>();

    for (var number : arr) {
      count.put(number, count.getOrDefault(number, 0) + 1);
    }

    for (var entry : count.entrySet()) {

      if (Objects.equals(entry.getKey(), entry.getValue())) {
        result = Math.max(result, entry.getKey());
      }
    }

    return result;
  }
}
