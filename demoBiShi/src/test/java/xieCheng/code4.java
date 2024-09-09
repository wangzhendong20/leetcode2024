package xieCheng;

import java.util.Scanner;

public class code4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            long sum = in.nextLong();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
            }

            long ans = 0L;
            long count = 0L;
            for (int i = 0; i < k; i++) {
                count += nums[i];
            }

            for (int i = 0; i <= n - k; i++) {
                if (count > sum) {
                    long tmp = count - sum;
                    long tmp1 = Math.min(nums[i+k-1],tmp);
                    nums[i+k-1] = nums[i+k-1] - tmp1;
                    ans += tmp1;
                    count -= tmp1;
                    tmp -= tmp1;
                    for (int j = i + k - 2; j >= i && tmp > 0 ; j--) {
                        tmp1 = Math.min(nums[j],tmp);
                        nums[j] -= tmp1;
                        ans += tmp1;
                        count -= tmp1;
                        tmp -= tmp1;
                    }
                }
                if (i + k < n) {
                    count = count - nums[i] + nums[i+k];
                }


            }
            System.out.println(ans);





        }
    }
}
