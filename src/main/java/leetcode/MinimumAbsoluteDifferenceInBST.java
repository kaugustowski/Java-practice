package leetcode;

/**
 * 530. Minimum Absolute Difference in BST
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the
 * values of any two different nodes in the tree.
 * <p>
 * A Binary Search Tree is a binary tree where for each node: - The left subtree of a node contains
 * only nodes with values less than the node's value. - The right subtree of a node contains only
 * nodes with values greater than the node's value. - Both the left and right subtrees must also be
 * binary search trees.
 * <p>
 * Example 1: Input: root = [4,2,6,1,3] Output: 1
 * <p>
 * Example 2: Input: root = [1,0,48,null,null,12,49] Output: 1
 * <p>
 * Constraints: - The number of nodes in the tree is in the range [2, 10^4]. - 0 <= Node.val <=
 * 10^5
 */
public class MinimumAbsoluteDifferenceInBST {

  TreeNode previous = null;
  int minDiff = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {

    inOrder(root);

    return minDiff;
  }


  public void inOrder(TreeNode node) {

    if (node.left != null) {
      inOrder(node.left);
    }

    if (previous != null) {
      minDiff = Math.min(minDiff, node.val - previous.val);
    }
    previous = node;

    if (node.right != null) {
      inOrder(node.right);
    }
  }
}
