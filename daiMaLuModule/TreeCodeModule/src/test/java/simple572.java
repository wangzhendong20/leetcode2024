import utils.TreeNode;

public class simple572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (compare(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || left.val != right.val) return false;

        return compare(left.left, right.left) && compare(left.right, right.right);
    }

}
