import utils.TreeNode;

public class simple543 {
    /**
     * 543.二叉树的直径
     * 后序遍历
     * 每次找到left和right的最大值，然后加上当前节点，更新ans
     * 之后继续向上找就是取Math.max(left,right) + 1;
     */

    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        traversal(root);

        return ans - 1;
    }

    private int traversal(TreeNode root) {
        if (root == null) return 0;

        int left = traversal(root.left);
        int right = traversal(root.right);

        ans = Math.max(ans, left+right+1);
        return Math.max(left,right) + 1;
    }
}
