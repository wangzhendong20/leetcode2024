import utils.TreeNode;

public class hard124 {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res = traverse(root);
        return Math.max(maxSum, res);
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);

        int right = traverse(root.right);

        int sum = root.val + Math.max(left,right);
        maxSum = Math.max(maxSum, Math.max(left+right+ root.val, Math.max(root.val, sum)));
        return Math.max(root.val, sum);

    }
}
