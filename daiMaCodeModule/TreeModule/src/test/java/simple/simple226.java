package simple;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class simple226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode cur) {
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;
    }
}
