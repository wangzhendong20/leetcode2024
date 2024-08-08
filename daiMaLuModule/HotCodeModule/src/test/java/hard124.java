import utils.TreeNode;

public class hard124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        int sum = Math.max(left, right) + root.val;

        maxSum = Math.max(maxSum, sum);
        maxSum = Math.max(maxSum, left + right + root.val);
        maxSum = Math.max(maxSum, root.val);

        return Math.max(sum, root.val);
    }
}
