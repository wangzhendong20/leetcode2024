package bilibili;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long count = 0;

            count += (long)n * (long)(n - 1) + 1;

            System.out.println(count);
        }
    }
}
