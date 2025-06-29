package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That
 * is, each element of nums is covered by exactly one of the ranges, and there is no integer x such
 * that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as: - "a->b" if a != b - "a" if a == b
 * <p>
 * Example 1: Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: The ranges are:
 * [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
 * <p>
 * Example 2: Input: nums = [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation: The ranges
 * are: [0,0] --> "0" [2,4] --> "2->4" [6,6] --> "6" [8,9] --> "8->9"
 * <p>
 * Constraints: 0 <= nums.length <= 20 -2^31 <= nums[i] <= 2^31 - 1 All the values of nums are
 * unique. nums is sorted in ascending order.
 */
public class SummaryRanges {

    private static final String RANGE_FORMAT = "%d->%d";
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int rangeStart = nums[0];
        int previous = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            if (current != previous + 1) {
                addRange(result, rangeStart, previous);
                rangeStart = current;
            }
            previous = current;
        }
        
        addRange(result, rangeStart, previous);
        
        return result;
    }
    
    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(String.format(RANGE_FORMAT, start, end));
        }
    }
}
