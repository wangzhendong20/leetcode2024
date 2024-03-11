package middle;

import java.util.Arrays;

public class middle416 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int bagSize = sum / 2;

        int[] dp = new int[bagSize+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }

        if (dp[bagSize] == bagSize) {
            return true;
        }
        return false;
    }
}
