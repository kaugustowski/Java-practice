package leetcode;

import java.util.HashMap;

/**
 * 383. Ransom Note
 * <p>
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using
 * the letters from magazine and false otherwise. Each letter in magazine can only be used once in
 * ransomNote.
 * <p>
 * Example 1: Input: ransomNote = "a", magazine = "b" Output: false
 * <p>
 * Example 2: Input: ransomNote = "aa", magazine = "aab" Output: true
 * <p>
 * Constraints: 1 <= ransomNote.length, magazine.length <= 10^5 ransomNote and magazine consist of
 * lowercase English letters.
 */
public class RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {

    HashMap<Character, Integer> magazineLettersWithCount = new HashMap<>();

    //put each letter count from the magazine to hashmap
    for (int i = 0; i < magazine.length(); i++) {

      if (magazineLettersWithCount.containsKey(magazine.charAt(i))) {
        magazineLettersWithCount.merge(magazine.charAt(i), 1, Integer::sum);
      } else {
        magazineLettersWithCount.put(magazine.charAt(i), 1);
      }
    }

    // for each letter in ransomNote decrement the letters count if there is such letter, otherwise return false
    for (int j = 0; j < ransomNote.length(); j++) {
      if(!magazineLettersWithCount.containsKey(ransomNote.charAt(j)) || magazineLettersWithCount.get(ransomNote.charAt(j)) == 0) {
        return false;
      } else {
        magazineLettersWithCount.merge(ransomNote.charAt(j), -1, Integer::sum);
      }
    }

    return true;
  }

  public boolean canConstruct2(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }

    int[] charCounts = new int[26];

    for (char c : magazine.toCharArray()) {
      charCounts[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      if (--charCounts[c - 'a'] < 0) {
        return false;
      }
    }

    return true;
  }
}
