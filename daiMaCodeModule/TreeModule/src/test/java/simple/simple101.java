package simple;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class simple101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left,root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {

        if ((left == null && right != null) || (left != null && right == null)) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        boolean isSame = outside && inside;
        return isSame;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
}
