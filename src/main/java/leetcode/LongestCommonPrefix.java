package leetcode;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings. If there
 * is no common prefix, return an empty string "".
 * <p>
 * Example 1: Input: strs = ["flower","flow","flight"] Output: "fl"
 * <p>
 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings.
 * <p>
 * Constraints: - 1 <= strs.length <= 200 - 0 <= strs[i].length <= 200 - strs[i] consists of only
 * lowercase English letters.
 */
public class LongestCommonPrefix {


  public String longestCommonPrefix(String[] strs) {

    var shortestLength = Integer.MAX_VALUE;
    var candidate = "";

    for (var string : strs) {
      if (string.length() < shortestLength) {
        shortestLength = string.length();
        candidate = string;
      }
    }

    for (int i = shortestLength; i >= 0; i--) {
      for (var string : strs) {
        if (!string.startsWith(candidate)) {
          candidate = candidate.substring(0,i);
        }
      }
    }

    return candidate;
  }
}
