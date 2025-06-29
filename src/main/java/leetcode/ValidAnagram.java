package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1: Input: s = "anagram", t = "nagaram" Output: true
 * <p>
 * Example 2: Input: s = "rat", t = "car" Output: false
 * <p>
 * Constraints: 1 <= s.length, t.length <= 5 * 10^4 s and t consist of lowercase English letters.
 */
public class ValidAnagram {


  public boolean isAnagram(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> sCounts = new HashMap<>();
    Map<Character, Integer> tCounts = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      var sChar = s.charAt(i);
      var tChar = t.charAt(i);

      sCounts.put(sChar, sCounts.getOrDefault(sChar, 0) + 1);
      tCounts.put(tChar, tCounts.getOrDefault(tChar, 0) + 1);

    }

    return sCounts.equals(tCounts);
  }
}
