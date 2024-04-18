package middle;

import utils.TreeNode;

public class middle701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return traversal(root,val);
    }

    private TreeNode traversal(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if (root.val > val) {
            root.left = traversal(root.left,val);
        }

        if (root.val < val) {
            root.right = traversal(root.right,val);
        }

        return root;
    }
}
