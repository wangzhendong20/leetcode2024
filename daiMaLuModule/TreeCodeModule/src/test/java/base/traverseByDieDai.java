package base;

import utils.TreeNode;

import java.util.*;

public class traverseByDieDai {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.right!= null) deque.push(node.right);
            if (node.left!= null) deque.push(node.left);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }



        return list;
    }



    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if (root == null) {
            return list;
        }
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.left!= null) deque.push(node.left);
            if (node.right!= null) deque.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }
}
