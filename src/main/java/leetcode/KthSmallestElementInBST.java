package leetcode;

/**
 * 230. Kth Smallest Element in a BST
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * Example 1: Input: root = [3,1,4,null,2], k = 1 Output: 1
 * <p>
 * Example 2: Input: root = [5,3,6,2,4,null,null,1], k = 3 Output: 3
 * <p>
 * Constraints: - The number of nodes in the tree is n. - 1 <= k <= n <= 10^4 - 0 <= Node.val <=
 * 10^4
 */
public class KthSmallestElementInBST {

  /**
   * Finds the kth smallest element in a BST.
   *
   * @param root The root of the binary search tree
   * @param k    The kth position to find (1-indexed)
   * @return The kth smallest element in the BST
   */
  int count = 1;
  int result = -1;

  public int kthSmallest(TreeNode root, int k) {

    inOrder(root, k);

    return result;
  }


  public void inOrder(TreeNode node, int k) {

    if(node == null) {
      return;
    }

    inOrder(node.left, k);

    if (count++ == k) {
      result = node.val;
      return;
    }
    inOrder(node.right, k);
  }
}
