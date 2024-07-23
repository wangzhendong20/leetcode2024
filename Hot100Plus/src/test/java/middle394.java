import java.util.Deque;
import java.util.LinkedList;

public class middle394 {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<String> stack =  new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                // 如果是数字，那就把数字压栈
                if (!stack.isEmpty() && Character.isDigit(c) && Character.isDigit(stack.peek().charAt(0))) {
                    stack.push(stack.pop() + c);
                } else { // 把字符压栈
                    stack.push(String.valueOf(c));
                }
            } else { //闭合
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    //取出当前[]里的字符
                    sb.append(stack.pop());
                }
                stack.pop();  // 弹出[
                if (!sb.isEmpty()) {
                    // 取出数字，之后拼接
                    int count = Integer.parseInt(stack.pop());
                    String sbStr = sb.toString();
                    for (int j = 1; j < count; j++) {
                        sb.append(sbStr);
                    }
                }
                //将拼接好的字符串压栈
                stack.push(String.valueOf(sb));
            }
        }

        //这个时候stack里剩下的都是拼接完成的字符串
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
