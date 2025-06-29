package leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    private final RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int result = solution.removeDuplicates(nums);
        assertEquals(0, result);
        assertArrayEquals(new int[]{}, nums);
    }

    @Test
    void testSingleElement() {
        int[] nums = {1};
        int result = solution.removeDuplicates(nums);
        assertEquals(1, result);
        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    void testNoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5};
        int result = solution.removeDuplicates(nums);
        assertEquals(5, result);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    void testAllDuplicates() {
        int[] nums = {2, 2, 2, 2, 2};
        int result = solution.removeDuplicates(nums);
        assertEquals(1, result);
        assertEquals(2, nums[0]);
    }

    @Test
    void testMixedDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4};
        
        int k = solution.removeDuplicates(nums);
        
        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

    @Test
    void testMultipleDuplicatesAtEnd() {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        int[] expectedNums = {1, 2, 3};
        
        int k = solution.removeDuplicates(nums);
        
        assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }
}
