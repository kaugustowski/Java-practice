package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49: Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any
 * order. An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2: Input: strs = [""] Output: [[""]]
 * <p>
 * Example 3: Input: strs = ["a"] Output: [["a"]]
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> res = new HashMap<>();
    for (String s : strs) {
      int[] count = new int[26];
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }
      String key = Arrays.toString(count);
      res.putIfAbsent(key, new ArrayList<>());
      res.get(key).add(s);
    }
    return new ArrayList<>(res.values());
  }
}
