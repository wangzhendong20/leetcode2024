import utils.TreeNode;

public class middle538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.right);
        sum += root.val;
        root.val += sum - root.val;
        traversal(root.left);
    }
}
