public class hard188 {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k+1];
        for (int i = 1; i < 2*k; i=i+2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < 2*k; j+=2) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] + prices[i]);
            }
        }

        return dp[prices.length-1][2*k];
    }
}
