package leetcode;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1
 * or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1: Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step
 * + 1 step 2. 2 steps
 * <p>
 * Example 2: Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top. 1. 1
 * step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * <p>
 * Constraints: - 1 <= n <= 45
 */
public class ClimbingStairs {

  public int climbStairs(int n) {

    if (n <= 2) {
      return n;
    }
    int[] memo = new int[n + 1];
    memo[1] = 1;
    memo[2] = 2;
    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n];
  }

  public int climbStairs2(int n) {

    if (n <= 2) {
      return n;
    }

    var one = 1;
    var two = 1;
    for (int i = 3; i <= n; i++) {
      var temp = two;
      two = one + two;
      one = temp;
    }
    return one + two;
  }
}
