package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3307. Find Kth Character in String Game II
 * <p>
 * You are given an integer k and an array of integers operations. The game starts with the string "a".
 * In each operation, you can perform one of the following:
 * <ul>
 *   <li>0: Append the string to itself (e.g., "a" becomes "aa")</li>
 *   <li>1: Append the string to itself but increment each character in the second half (e.g., "ab" becomes "abbc")</li>
 * </ul>
 * After performing all operations, return the k-th character (1-indexed) of the resulting string.
 * <p>
 * Constraints:
 * <ul>
 *   <li>1 <= k <= 10^18</li>
 *   <li>1 <= operations.length <= 100</li>
 *   <li>operations[i] is either 0 or 1</li>
 * </ul>
 */
public class KthCharacterInStringGameII {

  public char kthCharacter(long k, int[] operations) {
    int shift = 0; // total number of +1 (mod 26) operations
    List<Long> lengths = new ArrayList<>();
    long len = 1;

    for (int op : operations) {
      len *= 2;
      lengths.add(len);
      if (len >= k) break;
    }

    for (int i = lengths.size() - 1; i >= 0; i--) {
      long half = lengths.get(i) / 2;
      int op = operations[i];

      if (k > half) {
        k -= half;
        if (op == 1) shift++;
      }
      // else: k remains the same
    }

    // Apply total shift from 'a'
    return (char) (((shift) % 26) + 'a');
  }
}
