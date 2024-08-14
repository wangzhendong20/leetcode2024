import java.util.ArrayDeque;
import java.util.Deque;

public class middle402 {
    public String removeKdigits(String num, int k) {

        if (num.length() == k) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        // 单调栈，栈顶元素大于当前元素，则出栈
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 还有剩余k个，则全部出栈
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }


        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }

        if (sb.length() == 0) return "0";

        return sb.toString();
    }

}
