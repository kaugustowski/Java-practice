package leetcode;

//Given a binary tree, return the sum of values of nodes with even-valued grandparent.
//(A grandparent of a node is the parent of its parent, if it exists.)
//If there are no nodes with an even-valued grandparent, return 0.

public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, root.left, 0)+helper(root, root.right, 0);
    }

    private int helper(TreeNode grandparent, TreeNode parent, int sum){

        if (grandparent == null || parent == null) {
            return sum;
        }

        if (grandparent.val % 2 == 0 && parent.left != null) {
            sum += parent.left.val;
        }
        if (grandparent.val % 2 == 0 && parent.right != null) {
            sum += parent.right.val;
        }
        sum = helper(parent, parent.left, sum);
        sum = helper(parent, parent.right, sum);
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
