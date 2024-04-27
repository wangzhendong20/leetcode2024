import utils.TreeNode;

public class simple101 {
    /**
     * 分别对比left.left, right.right 和 left.right, right.left
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return traverse(root.left, root.right);
    }

    private boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;
        if (left.val != right.val) return false;

        boolean out = traverse(left.left, right.right);
        boolean inner = traverse(left.right, right.left);


        return out && inner;

    }
}
