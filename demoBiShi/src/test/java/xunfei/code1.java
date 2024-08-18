package xunfei;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int max = 0;
            String name = "";
            for (int i = 0; i < n; i++) {
                String s = in.next();
                int price = in.nextInt();
                if (price > max) {
                    max = price;
                    name = new String(s);
                }
            }
            System.out.println(name);
        }
    }
}
