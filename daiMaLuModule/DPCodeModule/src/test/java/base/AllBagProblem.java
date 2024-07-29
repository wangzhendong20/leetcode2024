package base;

public class AllBagProblem {

    private int bagProblem2(int[] weights,int[] values, int bagSize) {
        int[] dp = new int[bagSize+1];

        // 先遍历物品，再遍历背包 ->组合数
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }

        // 先遍历背包，再遍历物品 ->排列数
        for (int j = 0; j <= bagSize; j++) {
            for (int i = 0; i < weights.length; i++) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
                }
            }
        }

        return dp[bagSize];
    }
}
