package middle;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class middle513 {
    /**
     * 层次遍历方法
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return 0;
        int value = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = deque.poll();
                if (cur.left != null) deque.add(cur.left);
                if (cur.right != null) deque.add(cur.right);
                if (i == 0) {
                    value = cur.val;
                }
            }
        }
        return value;
    }

    int maxDepth = Integer.MIN_VALUE;
    int result;

    /**
     * 递归法，找到最深的最左节点
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        traversal(root,0);
        return result;
    }

    private void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
            return;
        }

        if (root.left != null) {
            depth++;
            traversal(root.left,depth);
            depth--;
        }

        if (root.right != null) {
            depth++;
            traversal(root.right,depth);
            depth--;
        }
        return;
    }
}
