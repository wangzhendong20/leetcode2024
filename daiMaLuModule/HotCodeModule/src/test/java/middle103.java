import utils.TreeNode;

import java.util.*;

public class middle103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(root);
        int level = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left!= null) deque.offer(node.left);
                if (node.right!= null) deque.offer(node.right);
            }
            if (level % 2 == 1) {
                Collections.reverse(list);
            }
            level++;
            res.add(list);
        }

        return res;
    }
}
