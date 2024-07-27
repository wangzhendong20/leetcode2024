import utils.TreeNode;

public class middle701 {
    TreeNode parent;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            if (val > parent.val) parent.right = node;
            else parent.left = node;
            return;
        }

        parent = root;
        if (val > root.val) {
            insert(root.right, val);
        }

        if (val < root.val) {
            insert(root.left, val);
        }

        return;
    }
}
