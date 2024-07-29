import java.util.Arrays;

public class simple674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] += dp[i-1];
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
