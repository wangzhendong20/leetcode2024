package middle;

public class middle213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int result1 = robRange(nums,0,nums.length-2);
        int result2 = robRange(nums,1,nums.length-1);

        return Math.max(result1,result2);
    }

    private int robRange(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left+1] = Math.max(nums[left],nums[left+1]);

        for (int i = left+2; i <= right; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[right];
    }
}
