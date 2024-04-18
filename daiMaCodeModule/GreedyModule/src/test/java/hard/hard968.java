package hard;

import utils.TreeNode;

public class hard968 {
    /**
     * 0：该节点无覆盖
     * 1：本节点有摄像头
     * 2：本节点有覆盖
     */
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (traversal(root) == 0) {
            ans++;
        }
        return ans;
    }
    private int traversal(TreeNode node) {
        if (node == null) return 2;
        int left = traversal(node.left);
        int right = traversal(node.right);

        if (left == 2 && right == 2) return 0;
        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
