package HuaWei.hauwei0124;

import java.util.Map;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int T = in.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println(minGoal(nums,N,T));
        }
    }


    /**
     * 二分答案
     * 就是先计算每次取算力的中间值，然后判断能否在T时刻内完成
     * 如果能在T时刻完成的话，那么就让right = mid，相当于减小算力
     * 如果不能完成的话，那么就让left = mid + 1，相当于加大算力
     * 这样的话，直到当left < right的时候，right就是最小算力
     * @param nums
     * @param N
     * @param T
     * @return
     */
    private static long minGoal(int[] nums, int N, int T) {
        long left = 0;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left,nums[i]);
        }
        long right = 500 * 50000;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(nums,N,T,mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return right;
    }

    private static boolean check(int[] nums, int n, int t, long mid) {
        //检测以当前算力能否在T时刻内完成
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + nums[i] > mid) {
                //下一个时刻
                cnt++;
                sum = nums[i];
            } else {
                //当前时刻
                sum += nums[i];
            }
            if (cnt > t) {
                //算不完
                return false;
            }
        }
        return true;
    }
}
