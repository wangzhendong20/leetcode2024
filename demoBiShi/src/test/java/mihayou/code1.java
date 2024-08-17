package mihayou;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();

            if (n <= 210) {
                System.out.println(n / 10);
                continue;
            }

            if (m <= 30) {
                int num = m * 90 + 300;
                int diff = n - num;
                int count = diff / 10;
                int sum = 30 + count;
                System.out.println(sum);
                continue;
            }

            if (m > 30) {
                int month = m / 30;
                int diffDay = m % 30;
                int sum = 0;
                while ( n > 300 && month > 0) {
                    sum += 30;
                    n -= 30 * 90 + 300;
                    month--;
                }
                if (n <= 210) {
                    sum += n / 10;
                    System.out.println(sum);
                    continue;
                }
                int num = diffDay * 90 + 300;
                int diff = n  - num;
                int count = diff / 10;
                sum += 30 + count;
                System.out.println(sum);
                continue;
            }

        }
    }
}
