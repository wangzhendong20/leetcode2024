package dewu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String s = in.next();
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();

            int max = 0;
            for (int i = 0; i < chars.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(chars[i]);
                } else {
                    if (chars[i] == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(chars[i]);
                    }
                    if (stack.isEmpty()) {
                        max = Math.max(max, i + 1);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
