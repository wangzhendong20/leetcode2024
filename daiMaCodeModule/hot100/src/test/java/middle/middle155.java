package middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class middle155 {
    /**
     * 使用一个优先队列，增加了时间和空间复杂度
     */
    class MinStack {
        Deque<Integer> stack;
        PriorityQueue<Integer> priorityQueue;
        public MinStack() {
            stack = new LinkedList<>();
            priorityQueue = new PriorityQueue<>();
        }

        public void push(int val) {
            stack.push(val);
            priorityQueue.add(val);
        }

        public void pop() {
            priorityQueue.remove(stack.peek());
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return priorityQueue.peek();
        }
    }

    class MinStack2 {
        Deque<Integer> stack;
        int min;
        public MinStack2() {
            stack = new LinkedList<>();
            min = Integer.MAX_VALUE;
        }

        /**
         * 每次push的时候都把上一个min先放进去;
         * @param val
         */
        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        /**
         * 每次pop的时候判断是否是min，如果当前Min出去了，那么我就把上一个Min重新记录并pop;
         */
        public void pop() {
            if (min == stack.pop()) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
