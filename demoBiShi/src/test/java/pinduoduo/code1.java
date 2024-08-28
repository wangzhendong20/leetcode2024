package pinduoduo;

import java.util.Scanner;

public class code1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int T = in.nextInt();
            while (T-- > 0) {
                int n = in.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = in.nextInt();
                }

            }

        }
    }
}
