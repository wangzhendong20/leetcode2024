import utils.TreeNode;

import java.util.HashMap;

public class middle437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ans = 0;
        long target = (long) targetSum;
        ans += traverse(root, target);
        ans += pathSum(root.left,targetSum);
        ans += pathSum(root.right, targetSum);

        return ans;

    }

    private int traverse(TreeNode root, long targetSum) {
        int sum = 0;
        if (root == null) return 0;

        if (root.val == targetSum) sum++;

        sum += traverse(root.left, targetSum - root.val);
        sum += traverse(root.right, targetSum - root.val);

        return  sum;
    }

    /**
     * 前缀和+哈希表
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);

        return traverse2(map, root, 0, targetSum);
    }

    private int traverse2(HashMap<Long, Integer> map, TreeNode root, long sum, int targetSum) {
        if (root == null) return 0;

        sum += root.val;
        int res = map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum,0) + 1);
        res += traverse2(map, root.left, sum, targetSum);
        res += traverse2(map, root.right, sum, targetSum);
        map.put(sum, map.get(sum) - 1);  //恢复现场

        return res;
    }

}
