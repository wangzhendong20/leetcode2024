package middle;

public class middl343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
            }
        }
        return dp[n];
    }
}
