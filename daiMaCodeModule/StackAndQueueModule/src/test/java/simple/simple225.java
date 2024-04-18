package simple;

import java.util.Deque;
import java.util.LinkedList;

public class simple225 {
    class MyStack {
        Deque<Integer> queue1;
        Deque<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Deque<Integer> queuetmp = queue1;
            queue1 = queue2;
            queue2 = queuetmp;

        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();

        }

        public boolean empty() {
            return queue1.isEmpty();
        }


    }
}
