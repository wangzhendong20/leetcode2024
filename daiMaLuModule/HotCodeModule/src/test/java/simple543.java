import utils.TreeNode;

public class simple543 {
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return maxLen - 1;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        int dis = left + right + 1;
        maxLen = Math.max(maxLen, dis);

        return Math.max(left, right) + 1;

    }
}
