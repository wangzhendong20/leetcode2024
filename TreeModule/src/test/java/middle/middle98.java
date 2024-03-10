package middle;

import utils.TreeNode;

public class middle98 {

    long maxValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);

        if (maxValue < root.val) {
            maxValue = root.val;
        } else {
            return false;
        }

        boolean right = isValidBST(root.right);

        return left && right;
    }
}
