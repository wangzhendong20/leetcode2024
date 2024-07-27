import utils.TreeNode;

public class middle98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (prev >= root.val) return false;
        prev = root.val;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}
