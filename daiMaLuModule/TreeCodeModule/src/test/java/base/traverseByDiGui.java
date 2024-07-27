package base;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class traverseByDiGui {
    public List<Integer> Traversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraverse(root, list);
        return list;
    }

    private void preorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preorderTraverse(root.left, list);
        preorderTraverse(root.right, list);
    }

    private void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }

    private void postorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorderTraverse(root.left, list);
        postorderTraverse(root.right, list);
        list.add(root.val);
    }


}
