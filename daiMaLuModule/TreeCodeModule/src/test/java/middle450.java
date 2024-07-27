import utils.TreeNode;

public class middle450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val == key) {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right,key);

        return root;
    }
}
