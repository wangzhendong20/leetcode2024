import java.util.Arrays;

public class middle279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n/2; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j - i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
                }
            }
        }

        return dp[n];
    }
}
