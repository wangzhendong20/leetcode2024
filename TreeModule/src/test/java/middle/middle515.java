package middle;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque  = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(max);
        }

        return res;
    }
}
