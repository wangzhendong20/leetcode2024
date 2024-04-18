package simple;

public class simple121 {
    /**
     * 贪心方法解决
     * @param prices
     * @return
     */
    public int maxProfitByGreedy(int[] prices) {
        int ans = 0;
        int low = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low,prices[i]);
            ans = Math.max(ans,prices[i] - low);
        }

        return ans;
    }


    /**
     * DP方法解决
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }

        return dp[prices.length-1][1];
    }
}
