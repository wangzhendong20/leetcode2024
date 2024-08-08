import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size - 1; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            TreeNode treeNode = deque.poll();
            res.add(treeNode.val);
            if (treeNode.left != null) deque.offer(treeNode.left);
            if (treeNode.right != null) deque.offer(treeNode.right);
        }

        return res;
    }
}
