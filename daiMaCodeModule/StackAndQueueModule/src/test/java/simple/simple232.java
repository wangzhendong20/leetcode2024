package simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class simple232 {
    class MyQueue {

        Deque<Integer> InStack;
        Deque<Integer> OutStack;

        public MyQueue() {
            InStack = new LinkedList<>();
            OutStack = new LinkedList<>();
        }

        public void push(int x) {
            InStack.push(x);
        }

        public int pop() {
            trans();
            return OutStack.pop();
        }

        public int peek() {
            trans();
            return OutStack.peek();
        }

        public boolean empty() {
            return InStack.isEmpty() && OutStack.isEmpty();
        }

        private void trans() {
            if (!OutStack.isEmpty()) {
                return;
            }
            while (!InStack.isEmpty()){
                OutStack.push(InStack.pop());
            }

        }
    }
}
