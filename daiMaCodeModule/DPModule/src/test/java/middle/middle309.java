package middle;

public class middle309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] -= prices[0]; // 持股票

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }

        return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
    }
}
