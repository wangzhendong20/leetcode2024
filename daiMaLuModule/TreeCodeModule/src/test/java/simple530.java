import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class simple530 {


    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (prev != null) {
                    minDiff = Math.min(minDiff, node.val - prev.val);
                }
                prev = node;
            }
        }

        return minDiff;
    }
}
