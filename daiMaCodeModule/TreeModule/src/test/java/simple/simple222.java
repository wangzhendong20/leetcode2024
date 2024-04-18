package simple;

import utils.TreeNode;

public class simple222 {
    /**
     * 普通二叉树求总结点个数的方法，没有考虑到完全二叉树的特性
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    /**
     * 针对完全二叉树的解法
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;

        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }


}
