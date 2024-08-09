import java.util.Deque;
import java.util.LinkedList;

public class hard32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int maxLen = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
