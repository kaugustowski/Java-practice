package leetcode;

import java.util.HashMap;

/**
 * 290. Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern. Here follow means a full
 * match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * <p>
 * Example 1: Input: pattern = "abba", s = "dog cat cat dog" Output: true
 * <p>
 * Example 2: Input: pattern = "abba", s = "dog cat cat fish" Output: false
 */
public class WordPattern {

  public boolean wordPattern(String pattern, String s) {
    HashMap<Character, String> dict = new HashMap<>();
    HashMap<String, Character> dict2 = new HashMap<>();
    String[] words = s.split(" ");

      if (words.length != pattern.length()) {
          return false;
      }

    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      String word = words[i];

      if (dict.containsKey(c)) {
          if (!dict.get(c).equals(word)) {
              return false;
          }
      } else {
          if (dict2.containsKey(word)) {
              return false; // word already mapped to another char
          }
        dict.put(c, word);
        dict2.put(word, c);
      }
    }
    return true;
  }
}
