import utils.TreeNode;

public class simple112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traverse(root, targetSum - root.val);
    }

    private boolean traverse(TreeNode root, int targetsum) {

        if (root.left == null && root.right == null && targetsum == 0) {
            return true;
        }
        if (root.left == null && root.right == null) return false;

        if (root.left != null) {
            if (traverse(root.left, targetsum - root.left.val)) {
                return true;
            }
        }

        if (root.right != null) {
            if (traverse(root.right, targetsum - root.right.val)) {
                return true;
            }
        }
        return false;
    }
}
