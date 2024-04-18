package simple;

import utils.TreeNode;

public class simple112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root,targetSum-root.val);
    }

    private boolean traversal(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null && targetSum == 0) return true;
        if (node.left == null && node.right == null) return false;

        if (node.left != null) {
            targetSum -= node.left.val;
            if (traversal(node.left,targetSum)) return true;
            targetSum += node.left.val;
        }

        if (node.right != null) {
            targetSum -= node.right.val;
            if (traversal(node.right,targetSum)) return true;
            targetSum += node.right.val;
        }
        return false;
    }
}
