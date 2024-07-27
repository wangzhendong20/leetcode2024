package base;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class levelTraverse {
    public List<List<Integer>> levelOrderTraverse(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left!= null) deque.add(node.left);
                if (node.right!= null) deque.add(node.right);
            }
            res.add(list);
        }
        return res;
    }


    public List<List<Integer>> levelOrderTraverse2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int depth = 0;
        order(root, res, depth);
        return res;
    }

    private void order(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(new LinkedList<>());
        res.get(depth).add(root.val);
        order(root.left, res, depth+1);
        order(root.right, res, depth+1);
    }
}
