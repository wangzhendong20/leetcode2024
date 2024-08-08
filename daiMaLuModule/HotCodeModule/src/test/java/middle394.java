import java.util.Deque;
import java.util.LinkedList;

public class middle394 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                if (!stack.isEmpty() && Character.isDigit(c) && Character.isDigit(stack.peek().charAt(0))) {
                    stack.push(stack.pop() + c);
                } else {
                    stack.push(String.valueOf(c));
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.append(stack.pop());
                }
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    temp.append(sb);
                }
                stack.push(temp.toString());
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
