import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class middle155 {
    class MinStack {
        Deque<Integer> stack;
//        PriorityQueue<Integer> priorityQueue;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<Integer>();
//            priorityQueue = new PriorityQueue<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            minStack.push(Math.min(val,minStack.peek())); // 保证每次栈顶都是最小值
            stack.push(val);
//            priorityQueue.add(val);
        }

        public void pop() {
//            priorityQueue.remove(stack.peek());
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
//            return priorityQueue.peek();
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
