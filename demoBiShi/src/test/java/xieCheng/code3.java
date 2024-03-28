package xieCheng;

import java.util.Arrays;
import java.util.Scanner;

public class code3 {
    /**
     * 40%
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long n = in.nextLong();
            long [] nums = new long[(int) n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
            }
            System.out.println(getMaxSum(nums, (int) n));
        }
    }

    private static long getMaxSum(long[] nums, int n) {
        long ans = 0;
        int left = 0;
        int start = 0;
        int end = 0;
        long minSum = 0;
        long curSum = 0;
        long minNum = Long.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            if (valid(nums[right])) {
                if (minNum > nums[right]) {
                    minNum = nums[right];
                }
                curSum += nums[right];
                if (curSum >= 0) {
                    left = right+1;
                    curSum = 0;
                    continue;
                }
            } else {
                left = right+1;
            }
            if (minSum > curSum) {
                start = left;
                end = right;
                minSum = curSum;
            }
        }

        if (minSum < 0) {
            long sum = 0;
            for (int i = start; i <= end; i++) {
                sum += nums[i];
            }
            ans = Arrays.stream(nums).sum() - (sum >> 1);
        } else {
            ans = Arrays.stream(nums).sum() - (minNum >> 1);
        }
        return ans;
    }

    private static boolean valid(long a) {
        if (a % (long) 2 == 0) {
            return true;
        }
        return false;
    }
}
