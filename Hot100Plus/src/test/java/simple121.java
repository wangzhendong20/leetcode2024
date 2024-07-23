public class simple121 {
    /**
     * 贪心
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }

        return ans;
    }

    /**
     * DP
     * 状态1：今天持有股票 dp[i][0]
     * 状态2：今天不持有股票 dp[i][1]
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
        }

        return dp[prices.length-1][1];
    }
}
