public class middle877 {
    /**
     * DP
     * 跟lc486基本一样
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        for (int j = 1; j < len; j++) {
            for (int i = j-1; i >= 0; i--) {
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }


        return dp[0][len-1] > 0;
    }
}
