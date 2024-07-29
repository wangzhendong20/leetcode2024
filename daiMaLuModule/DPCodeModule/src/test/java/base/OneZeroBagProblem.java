package base;

public class OneZeroBagProblem {
    public static void main(String[] args) {

    }

    private static int bagProblem(int[] weights,int[] values, int bagSize) {
        int[][] dp = new int[weights.length][bagSize+1];

        for (int j = weights[0]; j <= bagSize; j++) {
            dp[0][j] = values[0];
        }

        for (int i = 1; i < weights.length; i++) { //物品
            for (int j = 0; j <= bagSize; j++) {  //背包
                if (j < weights[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }

        for (int j = 0; j <= bagSize; j++) { //背包
            for (int i = 1; i < weights.length; i++) { //物品
                if (j < weights[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }


        return dp[weights.length-1][bagSize];

    }


    private static int bagProblem2(int[] weights,int[] values, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = bagSize; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }

        return dp[bagSize];
    }
}
