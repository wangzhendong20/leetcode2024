import utils.TreeNode;

public class simple101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        boolean in = traversal(left.left, right.right);
        boolean out = traversal(left.right, right.left);

        return in && out;
    }


}
