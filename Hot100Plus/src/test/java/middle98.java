import utils.TreeNode;

public class middle98 {
    /**
     * 98. Validate Binary Search Tree
     * 中序遍历，判断是否为升序
     */

    long maxVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);

        if (root.val > maxVal) {
            // 这个步骤应该是都是true才行，否则就不是BST
            maxVal = root.val;
        } else {
            return false;
        }

        boolean right = isValidBST(root.right);

        return left && right;
    }
}
