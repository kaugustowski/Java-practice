package leetcode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows: - The left subtree of a node contains only nodes with values
 * less than the node's value. - The right subtree of a node contains only nodes with values greater
 * than the node's value. - Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

  TreeNode prev = null;
  boolean result = true;

  public boolean isValidBST(TreeNode root) {

    inOrder(root);

    return result;
  }

  public void inOrder(TreeNode node) {

    if (node == null) {
      return;
    }

    inOrder(node.left);

    if (prev != null && prev.val >= node.val) {
      result = false;
      return;
    }
    prev = node;

    inOrder(node.right);

  }
}
