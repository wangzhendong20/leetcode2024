import utils.TreeNode;

public class simple222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }
}
