import java.util.Deque;
import java.util.LinkedList;

public class hard32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        Deque<Integer> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        stack.push(-1);//防止当第一个是')'的时候发生越界异常

        int ans = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                //左括号入栈
                stack.push(i);
            } else {
                //遇到右括号出栈
                stack.pop();
                if (stack.isEmpty()) {
                    //如果栈为空,要将当前右括号入栈，作为一个起点的标记
                    stack.push(i);
                } else {
                    //如果栈不为空，说明当前右括号和栈顶的左括号之间有一段有效括号，记录最大长度
                    ans = Math.max(ans, i  - stack.peek());
                }
            }
        }

        return ans;
    }
}
