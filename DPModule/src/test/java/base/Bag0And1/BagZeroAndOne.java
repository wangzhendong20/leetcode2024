package base.Bag0And1;

public class BagZeroAndOne {

    /**
     * 二维数组
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public int Bag0And1Problem(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize+1];
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);
            }
        }
        return dp[weight.length-1][bagSize];
    }


    /**
     * 滚动数组
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public int Bag0And1Problem2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        return dp[bagSize];
    }
}
