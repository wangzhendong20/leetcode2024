package xieCheng;

import java.math.BigDecimal;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder sb = new StringBuilder();
            int diff = k-1;
            for (int i = 1; i <= diff; i++) {
                sb.append(i +" ");
            }
            for (int i = n; i > diff; i--) {
                sb.append(i + " ");
            }

            System.out.println(sb);

        }
    }
}
