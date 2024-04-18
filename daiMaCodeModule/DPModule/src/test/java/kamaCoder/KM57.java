package kamaCoder;

import java.util.Scanner;

public class KM57 {

    /**
     * @param n 爬到楼顶要爬n个台阶
     * @param m 每次可以爬至多m (1 <= m < n)个台阶。
     * @return
     */
    public static int climbStairs(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i) dp[j] += dp[j - i];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(climbStairs(n, m));
    }
}
