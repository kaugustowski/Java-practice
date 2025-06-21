package leetcode;

/**
 * 88. Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements in nums1 and nums2 respectively. Merge
 * nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the
 * array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
 * the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 * <p>
 * Example 1: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output: [1,2,2,3,5,6]
 * <p>
 * Example 2: Input: nums1 = [1], m = 1, nums2 = [], n = 0 Output: [1]
 * <p>
 * Constraints: - nums1.length == m + n - nums2.length == n - 0 <= m, n <= 200 - 1 <= m + n <= 200 -
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 */
public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    if (n == 0) {
      return;
    }

    int index1 = m - 1;
    int index2 = n - 1;
    int current = m + n - 1;

    while (index1 >= 0 && index2 >= 0) {
      if (nums1[index1] > nums2[index2]) {
        nums1[current] = nums1[index1];
        index1--;
      } else {
        nums1[current] = nums2[index2];
        index2--;
      }
      current--;
    }

    while (index2 >= 0) {
      nums1[current--] = nums2[index2--];
    }
  }
}
