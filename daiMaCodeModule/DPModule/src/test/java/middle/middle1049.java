package middle;

import java.util.Arrays;

public class middle1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;

        int[] dp = new int[bagSize+1];

        for (int i = 0; i <= bagSize; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum - dp[bagSize] - dp[bagSize];
    }
}
