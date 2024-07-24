import java.util.Arrays;

public class middle416 {
    /**
     * 背包容量 sum/2
     * 状态转移方程：dp[j] = max(dp[j], dp[j-nums[i]] + nums[i])
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }


        System.out.println(Arrays.toString(dp));

        return dp[bagSize] * 2 == sum;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
}
