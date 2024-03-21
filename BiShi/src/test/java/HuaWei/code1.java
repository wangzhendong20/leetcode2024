package HuaWei;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if (n == 0) break;
            System.out.println(maxQiShui(n));
        }
    }

    private static int maxQiShui(int n) {
        int sum = 0;

        while (n > 2) {
            sum += n / 3;
            n = n % 3 + n / 3;
        }

        if (n == 2) {
            sum++;
        }

        return sum;
    }
}
