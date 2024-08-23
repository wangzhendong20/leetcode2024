import java.util.Arrays;

public class middle486 {

    /**
     * 记忆化递归
     * 甲乙比赛，甲先手面对区间[i...j]时，dp[i][j]表示甲对乙的净胜分。
     * 最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。
     *
     * 甲先手面对区间[i...j]时，
     * 如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
     * 如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。
     * @param nums
     * @return
     */
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, len - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] memo) {
        if (i > j) return 0;

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        int chooseLeft = nums[i] - dfs(nums, i + 1, j, memo);
        int chooseRight = nums[j] - dfs(nums, i, j - 1, memo);

        memo[i][j] = Math.max(chooseLeft, chooseRight);

        return memo[i][j];
    }

    /**
     * DP
     * @param nums
     * @return
     */
    public boolean predictTheWinner2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            // dp[i][j]：作为先手，在区间 nums[i..j] 里进行选择可以获得的相对分数
            dp[i][i] = nums[i];
        }

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j-1]);
            }
        }

        return dp[0][len-1] >= 0;
    }
}
