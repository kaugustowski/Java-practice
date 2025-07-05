package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TestTreeBuilder {
    public TreeNode build(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }
        
        // Remove brackets and split by comma
        String[] values = data.substring(1, data.length() - 1).split(",");
        if (values.length == 0 || values[0].equals("null")) {
            return null;
        }
        
        // Create root
        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();
            
            // Process left child
            if (index < values.length && !values[index].trim().equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[index].trim()));
                queue.offer(node.left);
            }
            index++;
            
            // Process right child
            if (index < values.length && !values[index].trim().equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[index].trim()));
                queue.offer(node.right);
            }
            index++;
        }
        
        return root;
    }
}
