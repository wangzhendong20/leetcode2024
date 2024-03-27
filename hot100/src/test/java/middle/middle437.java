package middle;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class middle437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        long target = (long) targetSum;
        int ans = traversal(root,target);
        ans += pathSum(root.left,targetSum);
        ans += pathSum(root.right,targetSum);
        return ans;
    }

    private int traversal(TreeNode node, long targetSum) {
        int sum = 0;

        if (node == null) return 0;

        if (node.val == targetSum) {
            sum++;
        }

        sum += traversal(node.left,targetSum-node.val);
        sum += traversal(node.right,targetSum-node.val);
        return sum;
    }

    /**
     * 前缀和
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> occurance = new HashMap<>();
        occurance.put(0L, 1);
        return dfs(root, targetSum, 0, occurance);
    }

    private int dfs(TreeNode root, int targetSum, long sumToNow, Map<Long, Integer> occurance) {
        if (root == null) {
            return 0;
        }
        long newSumToNow = sumToNow + root.val;
        int count = occurance.getOrDefault(newSumToNow - targetSum, 0);
        occurance.put(newSumToNow, occurance.getOrDefault(newSumToNow, 0) + 1);
        int left = dfs(root.left, targetSum, newSumToNow, occurance);
        int right = dfs(root.right, targetSum, newSumToNow, occurance);
        occurance.put(newSumToNow, occurance.getOrDefault(newSumToNow, 0) - 1);
        return count + left + right;
    }
}
