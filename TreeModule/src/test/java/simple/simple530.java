package simple;

import utils.TreeNode;

import java.util.TreeMap;

public class simple530 {
    int minValue = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return minValue;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) return;

        traversal(cur.left);

        if (pre != null) {
            minValue = Math.min(minValue, cur.val - pre.val);
        }
        pre = cur;

        traversal(cur.right);
    }


}
