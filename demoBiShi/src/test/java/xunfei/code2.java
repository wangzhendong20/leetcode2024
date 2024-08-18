package xunfei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                int num = in.nextInt();
                while (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    num++;
                }
                stack.push(num);
            }
            int size = stack.size();
            int[] res = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }

            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    System.out.print(res[i]);
                } else {
                    System.out.print(res[i] + " ");
                }
            }
        }
    }

}
