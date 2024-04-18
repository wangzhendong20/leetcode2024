package middle;

import java.util.Deque;
import java.util.LinkedList;

public class middle394 {
    /**
     * 1.仅使用一个栈来存储;
     * 2.遇到数字就判断前一个是不是数字，之后拼接压栈;
     * 3.当遇到']'时，开始构建字符串;
     * 将'['之前的字符都拿出来拼接;
     * 之后获取数字,再拼接
     * 然后再将新字符串压栈
     * 4.最后将栈里元素出栈反转
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                if (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)) && Character.isDigit(c)) {
                    stack.push(stack.pop()+c);
                } else {
                    stack.push(String.valueOf(c));
                }
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.append(stack.pop());
                }
                stack.pop();
                if (!sb.isEmpty()) {
                    int num = Integer.parseInt(String.valueOf(stack.pop()));
                    String sbStr = sb.toString();
                    for (int j = 1; j < num; j++) {
                        sb.append(sbStr);
                    }
                }
                stack.push(String.valueOf(sb));
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return String.valueOf(ans.reverse());
    }
}
