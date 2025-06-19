package leetcode;

/**
 * 28. Find the Index of the First Occurrence in a String
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in
 * haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1: Input: haystack = "sadbutsad", needle = "sad" Output: 0 Explanation: "sad" occurs at
 * index 0 and 6. The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2: Input: haystack = "leetcode", needle = "leeto" Output: -1 Explanation: "leeto" did not
 * occur in "leetcode", so we return -1.
 */
public class FindFirstOccurrenceInString {

  public int strStr(String haystack, String needle) {

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {

      if (haystack.charAt(i) == needle.charAt(0)) {
        for (int j = needle.length() - 1; j >= 0; j--) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            break;
          } else if (j == 0) {
            return i;
          }
        }
      }
    }
    return -1;
  }

  public int strStr2(String haystack, String needle) {
    // Edge cases
    if (needle.isEmpty()) return 0;
    if (haystack.length() < needle.length()) return -1;

    int n = haystack.length();
    int m = needle.length();

    for (int i = 0; i <= n - m; i++) {
      if (isMatch(haystack, needle, i)) {
        return i;
      }
    }
    return -1;
  }

  private boolean isMatch(String haystack, String needle, int start) {
    for (int i = 0; i < needle.length(); i++) {
      if (haystack.charAt(start + i) != needle.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
