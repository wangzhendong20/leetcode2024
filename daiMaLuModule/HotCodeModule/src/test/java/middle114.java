import utils.TreeNode;

public class middle114 {
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
