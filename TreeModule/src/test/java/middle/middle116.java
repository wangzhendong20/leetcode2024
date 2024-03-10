package middle;

import utils.HasNextNode;

import java.util.Deque;
import java.util.LinkedList;

public class middle116 {
    public HasNextNode connect(HasNextNode root) {
        if (root == null) return root;
        Deque<HasNextNode> deque = new LinkedList<>();
        deque.add(root);
        root.next = null;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                HasNextNode node = deque.poll();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = deque.peek();
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
        }
        return root;
    }
}
