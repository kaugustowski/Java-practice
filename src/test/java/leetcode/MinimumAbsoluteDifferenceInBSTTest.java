package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MinimumAbsoluteDifferenceInBSTTest {
    private final MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();

    @Test
    void testExample1() {
        // Given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        
        // When
        int result = solution.getMinimumDifference(root);
        
        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testExample2() {
        // Given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        
        // When
        int result = solution.getMinimumDifference(root);
        
        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testTwoNodes() {
        // Given
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        
        // When
        int result = solution.getMinimumDifference(root);
        
        // Then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testConsecutiveNumbers() {
        // Given
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        // When
        int result = solution.getMinimumDifference(root);
        
        // Then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testLargeTree() {
        // Given
        // Build a BST with values [1, 2, 3, 4, 5, 6, 7]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        
        // When
        int result = solution.getMinimumDifference(root);
        
        // Then
        assertThat(result).isEqualTo(1);
    }
}
