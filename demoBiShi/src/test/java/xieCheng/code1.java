package xieCheng;

import java.util.Scanner;

public class code1 {
    /**
     * ac
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();

            StringBuilder s1 = new StringBuilder("you");
            StringBuilder s2 = new StringBuilder("uoy");
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans.append(s1);
                } else {
                    ans.append(s2);
                }
            }
            System.out.println(String.valueOf(ans));
        }
    }
}
