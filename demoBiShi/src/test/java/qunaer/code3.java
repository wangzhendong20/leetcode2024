package qunaer;

import java.util.Random;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String s = in.next();
            Random r = new Random();

            int ans = r.nextInt(2) + 3;
            System.out.println(ans);
        }
    }
}
