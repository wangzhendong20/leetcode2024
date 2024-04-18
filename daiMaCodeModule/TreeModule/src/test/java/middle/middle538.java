package middle;

import utils.TreeNode;

public class middle538 {
    int sum = 0;

    /**
     * 右中左
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);

        sum += root.val;
        root.val = sum;

        convertBST(root.left);

        return root;
    }

}
