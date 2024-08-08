import utils.TreeNode;

public class middle98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);

        if (pre >= root.val) {
            return false;
        } else {
            pre = root.val;
        }

        boolean right = isValidBST(root.right);

        return left && right;
    }
}
