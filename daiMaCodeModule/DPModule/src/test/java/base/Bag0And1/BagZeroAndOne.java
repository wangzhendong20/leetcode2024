package base.Bag0And1;

import java.util.ArrayList;
import java.util.List;

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
    public static int Bag0And1Problem2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        return dp[bagSize];
    }


    /**
     * 具体方案
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int Bag0And1Problem2Plus(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        // 回溯求解具体方案
        List<Integer> solution = new ArrayList<>();
        int remainingCapacity = bagSize;
        for (int i = weight.length - 1; i >= 0; i--) {
            if (remainingCapacity >= weight[i] && dp[remainingCapacity] == dp[remainingCapacity - weight[i]] + value[i]) {
                solution.add(0,(i + 1));
                remainingCapacity -= weight[i];
            }
        }
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + " ");
        }

        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;
        int max_value = Bag0And1Problem2(weights, values, capacity);
        System.out.println("背包能装的最大价值为：" + max_value);
    }
}
