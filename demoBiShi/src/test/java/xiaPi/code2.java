package xiaPi;

import java.util.ArrayList;
import java.util.List;

public class code2 {
    /**
     * 0-1背包问题求具体方案
     * @param costs
     * @param coins
     * @return
     */
    public static int[] solution(int[] costs, int coins) {
        int[] dp = new int[coins+1];
        boolean[] taken = new boolean[coins + 1];

        for (int i = 0; i < costs.length; i++) {
            for (int j = coins; j >= costs[i]; j--) {
                if (dp[j] <= dp[j-costs[i]]+1) {
                    dp[j] = dp[j-costs[i]]+1;
                    taken[j] = true;
                }
            }
        }
        // 回溯求解具体方案
        List<Integer> res = new ArrayList<>();
        int remainingCapacity = coins;
        for (int i = costs.length - 1; i >= 0; i--) {
            if (remainingCapacity >= costs[i] && dp[remainingCapacity] == dp[remainingCapacity - costs[i]] + 1) {
                res.add(i+1);
                remainingCapacity -= costs[i];
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


}
