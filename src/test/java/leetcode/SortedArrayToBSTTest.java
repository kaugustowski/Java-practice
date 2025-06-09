package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayToBSTTest {
    private final SortedArrayToBST solution = new SortedArrayToBST();

    @ParameterizedTest
    @NullAndEmptySource
    void shouldHandleEmptyOrNullInput(int[] emptyArray) {
        assertNull(solution.sortedArrayToBST(emptyArray));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void shouldCreateBalancedBST(int[] nums) {
        // When
        TreeNode result = solution.sortedArrayToBST(nums);
        
        // Then
        assertTrue(isBalanced(result), "Tree should be balanced");
        assertTrue(isValidBST(result), "Should be a valid BST");
        assertArrayEquals(nums, inOrderTraversal(result).stream().mapToInt(i -> i).toArray(),
            "In-order traversal should match sorted input array");
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Single element
            Arguments.of(new int[]{1}),
            // Two elements
            Arguments.of(new int[]{1, 2}),
            // Three elements
            Arguments.of(new int[]{1, 2, 3}),
            // Even number of elements
            Arguments.of(new int[]{-10, -3, 0, 5}),
            // Odd number of elements
            Arguments.of(new int[]{-10, -3, 0, 5, 9}),
            // Negative numbers
            Arguments.of(new int[]{-5, -4, -3, -2, -1}),
            // Large array
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
            // Single repeated value
            Arguments.of(new int[]{5, 5, 5, 5, 5})
        );
    }
    
    // Helper method to check if the tree is balanced
    private boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Helper method to check if the tree is a valid BST
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && 
               isValidBST(node.right, node.val, max);
    }
    
    // Helper method to perform in-order traversal and return values as list
    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
    
    private void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inOrderHelper(node.left, result);
        result.add(node.val);
        inOrderHelper(node.right, result);
    }
}
