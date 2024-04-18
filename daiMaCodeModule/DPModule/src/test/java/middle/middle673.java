package middle;

import java.util.Arrays;

public class middle673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];  //递增子序列的最长长度
        int[] count = new int[nums.length];  //自增子序列的个数
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) { //长度增加
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j]+1 == dp[i]) {  //长度未增，但个数增加
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];  //记录最长长度
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) ans += count[i];
        }
        return ans;
    }
}
