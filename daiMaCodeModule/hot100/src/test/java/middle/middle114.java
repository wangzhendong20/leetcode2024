package middle;

import utils.ListNode;
import utils.TreeNode;

public class middle114 {
    /**
     * 找到当前节点左子树的最右节点，然后将当前节点右子树跟在最右节点后面，
     * 之后把左子树放到右子树的位置，
     * 之后处理下一个节点
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }
    }
}
