package meiTuan;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int k = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int a = (k - 2 * x - y) / 3;
            int b = (x + k + 2*y) / 3;
            int c = (x + k - y) / 3;
            System.out.println(a + " " + b + " " + c);
        }
    }
}
