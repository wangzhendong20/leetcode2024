import utils.TreeNode;

public class middle513 {
    public int findBottomLeftValue(TreeNode root) {
        traverse(root,1);
        return res;
    }

    int maxDepth = Integer.MIN_VALUE;
    int res;

    private void traverse(TreeNode root, int depth) {

        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }

        if (root.left != null) {
            depth++;
            traverse(root.left,depth);
            depth--;
        }

        if (root.right != null) {
            depth++;
            traverse(root.right,depth);
            depth--;
        }

        return;
    }
}
