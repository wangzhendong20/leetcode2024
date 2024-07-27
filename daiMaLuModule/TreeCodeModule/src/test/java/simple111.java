import utils.TreeNode;

public class simple111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return 1 + right;
        }
        if (root.left != null && root.right == null) {
            return 1 + left;
        }

        return 1 + Math.min(left, right);

    }
}
