package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * <p>Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.</p>
 *
 * <table>
 *   <tr><th>Symbol</th><th>Value</th></tr>
 *   <tr><td>I</td><td>1</td></tr>
 *   <tr><td>V</td><td>5</td></tr>
 *   <tr><td>X</td><td>10</td></tr>
 *   <tr><td>L</td><td>50</td></tr>
 *   <tr><td>C</td><td>100</td></tr>
 *   <tr><td>D</td><td>500</td></tr>
 *   <tr><td>M</td><td>1000</td></tr>
 * </table>
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the one is before the
 * five we subtract it making four. The same principle applies to the number nine, which is written
 * as IX. There are six instances where subtraction is used:</p>
 *
 * <ul>
 *   <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 *   <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 *   <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 *
 * <h3>Examples</h3>
 * <pre>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * </pre>
 *
 * <pre>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V = 5, III = 3.
 * </pre>
 *
 * <pre>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 *
 * <h3>Constraints</h3>
 * <ul>
 *   <li>1 <= s.length <= 15</li>
 *   <li>s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')</li>
 *   <li>It is guaranteed that s is a valid roman numeral in the range [1, 3999]</li>
 * </ul>
 */
public class RomanToInteger {

  public int romanToInt(String s) {

    Map<Character, Integer> romanValues = new HashMap<>();

    romanValues.put('I', 1);
    romanValues.put('V', 5);
    romanValues.put('X', 10);
    romanValues.put('L', 50);
    romanValues.put('C', 100);
    romanValues.put('D', 500);
    romanValues.put('M', 1000);

    var result = 0;
    var value = 0;
    var nextValue = 0;

    for (int i = 0; i < s.length(); i++) {

      var isLast = i + 1 == s.length();
      value = romanValues.get(s.charAt(i));
      nextValue = isLast ? romanValues.get(s.charAt(i)) : romanValues.get(s.charAt(i+1));

      if(isLast || value >= nextValue) {
        result += value;
      } else {
        result -= value;
      }
    }

    return result;
  }
}