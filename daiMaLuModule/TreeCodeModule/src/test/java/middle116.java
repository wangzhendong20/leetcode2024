import java.util.Deque;
import java.util.LinkedList;

public class middle116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                if (i == 0) {
                    prev = node;
                } else {
                    prev.next = node;
                    prev = prev.next;
                }
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            prev.next = null;
        }
        return root;
    }
}
