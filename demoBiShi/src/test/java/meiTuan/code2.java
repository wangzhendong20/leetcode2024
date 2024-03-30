package meiTuan;

import org.dong.Main;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long n = in.nextLong();
            long[] nums = new long[(int)n];
            long max = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
                max = Math.max(nums[i], max);
            }

            long[] maxNums = new long[(int) n];
            for (int i = 0; i < n; i++) {
                if (max < nums[i] * 2) {
                    maxNums[i] = nums[i] * 2;
                } else {
                    maxNums[i] = max;
                }
                if (i == n-1) {
                    System.out.print(maxNums[i]);
                } else {
                    System.out.print(maxNums[i] + " ");
                }

            }


        }
    }
}
