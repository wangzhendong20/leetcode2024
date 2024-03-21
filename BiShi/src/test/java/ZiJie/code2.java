package ZiJie;

import java.util.Scanner;

public class code2 {
    /**
     * 只过了一个点
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int len = in.nextInt();
            if (n <= 2) {
                System.out.println(0);
                break;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println(getPlan(nums,len) % 99997867);
        }
    }

    private static Long getPlan(int[] nums, int len) {
        int i = 0;
        Long sum = 0L;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] - nums[i] >= len) {
                if (nums[j] - nums[i] > len) {
                    i++;
                    continue;
                }
                int n = j - i + 1;
                if (n >= 3) {
                    sum += (Jie(n))/(Jie(3)*Jie(n-3));
                    i++;
                }
            }
        }
        return sum;
    }

    private static Long Jie(int n) {
        Long res = 1L;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }


    /**
     * 评论题解
     * 滑动窗口
     * @param num
     * @return
     */
    private static long calC(long num) {
        return num * (num - 1) / 2;
    }

    public static void main2(String[] args) {
        int mod = 99997867;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), D = sc.nextInt();
        long cnt = 0;
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        int left = 0, right = 2;
        while (right < N) {
            if (locs[right] - locs[left] > D) left++;
            else if (right - left < 2) right++;
            else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= mod;
        System.out.println(cnt);
    }

}
