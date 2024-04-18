package simple;

import utils.TreeNode;

public class simple110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    private int getHeight(TreeNode cur) {
        if (cur == null) return 0;
        int leftHeight = getHeight(cur.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(cur.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
