package leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }


    private TreeNode buildTree(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int startingIndex = left + (right - left)/ 2;
        var leftSubtree = buildTree(nums, left, startingIndex -1);
        var rightSubtree = buildTree(nums, startingIndex + 1, right);

        return new TreeNode(nums[startingIndex], leftSubtree , rightSubtree);
    }

}
