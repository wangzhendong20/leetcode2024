package base.BagAll;

import java.util.ArrayList;
import java.util.List;

public class BagByAll {
    /**
     * 二维数组  （先遍历物品，再遍历背包  ->组合数）版本
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public int BagAllProblem(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize+1];
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]] + value[i]);
            }
        }
        return dp[weight.length-1][bagSize];
    }


    /**
     * 滚动数组  （先遍历物品，再遍历背包  ->组合数）版本
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int BagAllProblem2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        return dp[bagSize];
    }


    /**
     * 求具体方案
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public static int BagAllProblem2Plus(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];
        int[][] choices = new int[weight.length][bagSize + 1]; // 记录每种物品放入背包的数量

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize; j++) {
                if (dp[j] < dp[j - weight[i]] + value[i]) {
                    dp[j] = dp[j - weight[i]] + value[i];
                    choices[i][j] = choices[i][j - weight[i]] + 1; // 记录放入数量
                }
            }
        }


        // 回溯求解具体方案
        StringBuilder solution = new StringBuilder();
        int remainingCapacity = bagSize;
        for (int i = weight.length - 1; i >= 0; i--) {
            while (remainingCapacity >= weight[i] && dp[remainingCapacity] == dp[remainingCapacity - weight[i]] + value[i]) {
                int count = choices[i][remainingCapacity];
                solution.insert(0, "物品" + (i + 1) + "数量" + count + " ");
                remainingCapacity -= count * weight[i];
            }
        }
        System.out.println(solution);

        return dp[bagSize];
    }

    /**
     * 二维数组  （先遍历背包，再遍历物品  ->排列数）版本
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public int BagAllProblem3(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize+1];
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int j = 0; j <= bagSize; j++) {
            for (int i = 1; i < weight.length; i++) {
                if (j - weight[i] >= 0) dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]] + value[i]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[weight.length-1][bagSize];
    }


    /**
     * 滚动数组  （先遍历背包，再遍历物品  ->排列数）版本
     * @param weight
     * @param value
     * @param bagSize
     * @return
     */
    public int BagAllProblem4(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int j = 0; j <= bagSize; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j - weight[i] >= 0) dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }

        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        int max_value = BagAllProblem2Plus(weights, values, capacity);
        System.out.println("背包能装的最大价值为：" + max_value);
    }
}
