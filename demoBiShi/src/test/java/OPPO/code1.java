package OPPO;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int t = in.nextInt();
            int[] nums = new int[n];
            long sum = 0L;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                sum += nums[i];
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                long newSum = sum - nums[i] * 2L;
                if (newSum >= 0 && newSum <= t) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }
}
