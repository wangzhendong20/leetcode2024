package simple;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class simple104 {
    /**
     * 层次遍历迭代法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int height = 0;

        while (!deque.isEmpty()) {
            height++;
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return height;
    }

    public int maxDepth2(TreeNode root) {
        return getDepth(root);
    }

    /**
     * 后序遍历递归法
     * @param node
     * @return
     */
    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftdepth = getDepth(node.left);
        int rightdepth = getDepth(node.right);
        int depth = 1 + Math.max(leftdepth,rightdepth);
        return depth;
    }

}
