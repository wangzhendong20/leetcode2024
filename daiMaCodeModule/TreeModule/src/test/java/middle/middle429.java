package middle;

import utils.NTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle429 {
    public List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<NTreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NTreeNode node = deque.poll();
                list.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    if (node.children.get(j) != null) deque.add(node.children.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
