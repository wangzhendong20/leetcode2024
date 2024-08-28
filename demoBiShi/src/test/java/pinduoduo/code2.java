package pinduoduo;

import java.util.*;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int T = in.nextInt();
            for (int t = 0; t < T; t++) {
                int n = in.nextInt();
                long[] nums = new long[n];

                for (int i = 0; i < n; i++) {
                    nums[i] = in.nextLong();
                }

                long ans = 0;
                long min = n;

                for (int i = 0; i < n; i++) {
                    if (nums[i] % 2 == 0) {
                        long tmp = 0;
                        long num = nums[i];
                        while (num % 2 == 0) {
                            tmp++;
                            num = num / 2;
                        }
                        min = Math.min(min, tmp);
                    } else {
                        min = 0;
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (nums[i] % 2 == 0) {
                        ans++;
                    }
                }

                if (min == 0) {
                    System.out.println(ans);
                } else {
                    System.out.println(ans + min - 1);
                }

            }
        }
    }
}
