package middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class middle150 {
    public int evalRPN(String[] tokens) {
        Deque<Long> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                long num1 = stack.pop();
                long num2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(num1+num2);
                }
                if (token.equals("-")) {
                    stack.push(num2-num1);
                }
                if (token.equals("*")) {
                    stack.push(num1*num2);
                }
                if (token.equals("/")) {
                    stack.push(num2/num1);
                }
            } else {
                stack.push(Long.valueOf(token));
            }
        }
        return stack.pop().intValue();
    }
}
