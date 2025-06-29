package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * <p>
 * An input string is valid if: 1. Open brackets must be closed by the same type of brackets. 2.
 * Open brackets must be closed in the correct order. 3. Every close bracket has a corresponding
 * open bracket of the same type.
 * <p>
 * Example 1: Input: s = "()" Output: true
 * <p>
 * Example 2: Input: s = "()[]{}" Output: true
 * <p>
 * Example 3: Input: s = "(]" Output: false
 * <p>
 * Constraints: 1 <= s.length <= 10^4 s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

  private static final Map<Character, Character> BRACKET_PAIRS = Map.of(
      ')', '(',
      ']', '[',
      '}', '{'
  );


  public boolean isValid(String s) {

    Deque<Character> stack = new ArrayDeque<>();

    for (var character : s.toCharArray()) {
      if(!BRACKET_PAIRS.containsKey(character)) {
        stack.push(character);
      } else if (stack.peek() == BRACKET_PAIRS.get(character)) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
