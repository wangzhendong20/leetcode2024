import utils.TreeNode;

public class middle114 {
    /**
     * 114. 二叉树展开为链表
     * 如果存在左子树，那么就找到左子树的最右节点，然后将右子树接到最右节点的右边，然后将左子树接到根节点的右边。
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;
                root.right = root.left;
                root.left = null;

            } else {
                root = root.right;
            }
        }
    }
}
