package middle;

import utils.TreeNode;

public class middle450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left != null && root.right == null) return root.left;
            else if (root.left == null && root.right != null) return root.right;
            else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
                return root;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left,key);
        }

        if (root.val < key) {
            root.right = deleteNode(root.right,key);
        }

        return root;
    }

}
