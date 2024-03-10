package simple;

import utils.TreeNode;

public class simple404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum = root.left.val;
        }

        int rightSum = sumOfLeftLeaves(root.right);

        return leftSum + rightSum;
    }
}
