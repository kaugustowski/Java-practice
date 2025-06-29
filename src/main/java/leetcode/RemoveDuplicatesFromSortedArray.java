package leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
 * that each unique element appears only once. The relative order of the elements should be kept the
 * same. Then return the number of unique elements in nums.
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array int[] expectedNums = [...]; // The expected answer with
 * correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length; for (int i = 0; i < k; i++) { assert nums[i] == expectedNums[i];
 * }
 * <p>
 * If all assertions pass, then your solution will be accepted.
 */
public class RemoveDuplicatesFromSortedArray {


  public int removeDuplicates(int[] nums) {
      if (nums.length == 0) {
          return 0;
      }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
