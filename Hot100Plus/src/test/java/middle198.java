public class middle198 {
    /**
     * DP
     * dp[i]表示抢劫到i个房子的最大收益
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            // 1.抢前一个房子，这一个就不抢
            // 2.抢前两个房子，就抢这个房子
            // 比较哪个大就选哪个。
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[nums.length];

    }
}
