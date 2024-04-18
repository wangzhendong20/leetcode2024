package simple;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class simple111 {
    /**
     * 层次遍历迭代法
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            depth++;
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return depth;
    }

    public int minDepth2(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

        if (node.left == null && node.right != null) {
            return 1 + rightDepth;
        }

        if (node.left != null && node.right == null) {
            return 1 + leftDepth;
        }

        int depth = 1 + Math.min(leftDepth,rightDepth);
        return depth;
    }
}
