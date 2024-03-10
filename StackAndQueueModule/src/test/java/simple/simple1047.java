package simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class simple1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
