package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class hard32 {
    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        //如果为空
        if (s == null || s.length() == 0) return 0;
        //建立一个栈
        Deque<Integer> stack = new ArrayDeque<>();
        //这一步可以防止当第一个Character是')'的时候发生越界异常
        stack.push(-1);
        //System.out.println(stack);
        //可以看到stack是[-1]
        int res = 0;
        //遍历栈找寻合适的左右括号
        for (int i = 0; i < s.length(); i++) {
            //如果找到左括号则入栈，为寻找对应右括号做铺垫
            if (s.charAt(i) == '(') stack.push(i);
            else {
                //如果是右括号则出栈
                stack.pop();
                //但是如果栈是空的话还是得（单身的）把右括号放进来
                if (stack.isEmpty()) stack.push(i);
                else {
                    //当前全部人数减去剩余无法配对的人数（单身）即res
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    /**
     * DP
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i-1] + 2 + ((i - dp[i-1]) >= 2 ? dp[i - dp[i-1] - 2] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
