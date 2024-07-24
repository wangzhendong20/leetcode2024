public class middle1143 {
    /**
     * DP
     * dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符的最长公共子序列的长度
     * if (text1.charAt(i-1) == text2.charAt(j-1)) 那么就是前 i-1 个字符和前 j-1 个字符的最长公共子序列的长度 + 1
     * 如果不等的话就是从前 i 个字符和前 j-1 个字符的最长公共子序列的长度 和 从前 i-1 个字符和前 j 个字符的最长公共子序列的长度中选择最大的
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
