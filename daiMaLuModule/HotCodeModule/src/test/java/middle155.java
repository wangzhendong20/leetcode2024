import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class middle155 {
    class Node {
        int val;
        int min;
        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }
    }

    class MinStack {
        Deque<Node> stack;

        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            int min = Math.min(val, stack.isEmpty() ? val : stack.peek().min);
            stack.push(new Node(val, min));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
}
