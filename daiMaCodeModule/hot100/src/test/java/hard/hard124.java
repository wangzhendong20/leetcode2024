package hard;

import utils.TreeNode;

public class hard124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return max;
    }

    /**
     * 后序遍历
     * 求出左右节点的最大值
     * 如果加上当前节点元素进行判断max
     * 返回上层的是当前节点+左右节点的最大值
     * @param node
     * @return
     */
    private int traversal(TreeNode node) {
        if(node == null) return 0;


        int left = Math.max(traversal(node.left),0);
        int right = Math.max(traversal(node.right),0);

        int sum = node.val + left + right;
        max = Math.max(max,sum);
        return node.val + Math.max(left,right);
    }


}
