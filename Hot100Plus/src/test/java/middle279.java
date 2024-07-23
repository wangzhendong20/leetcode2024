import java.util.Arrays;

public class middle279 {
    /**
     * dp[j] 代表 j 组成的完全平方数的最少个数
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= n/2; i++) { // 完全平方数
            for (int j = i*i; j <= n; j++) { //每轮更新
                if (dp[j - i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1); //选择了一个就加1
                }
            }
        }

        for (int num : dp) {
            System.out.print(num + " ");
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        numSquares(n);
    }
}
