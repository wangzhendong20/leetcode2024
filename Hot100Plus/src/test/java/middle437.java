import utils.TreeNode;

import java.util.HashMap;

public class middle437 {

    /**
     * 前缀和+哈希表
     * 在二叉树上，前缀和相当于从根节点开始的路径元素和。用哈希表 cnt 统计前缀和的出现次数，
     * 当我们递归到节点 node 时，设从根到 node 的路径元素和为 s，那么就找到了 cnt[s−targetSum] 个符合要求的路径，加入答案。
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
