import utils.TreeNode;

public class middle437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        long target = (long) targetSum;
        int ans = traversal(root, target);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    private int traversal(TreeNode root, long targetSum) {
        int sum = 0;

        if (root == null) {
            return 0;
        }

        if (root.val == targetSum) {
            sum++;
        }

        sum += traversal(root.left, targetSum - root.val);
        sum += traversal(root.right, targetSum - root.val);

        return sum;
    }
}
