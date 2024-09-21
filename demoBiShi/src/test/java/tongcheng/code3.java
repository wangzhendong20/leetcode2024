package tongcheng;

public class code3 {
    public int numberOfWays (int startPos, int endPos, int k) {
        int n = 2000;
        int[][] dp = new int[2*n+1][k+1];
        dp[startPos+n][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = startPos - i; j <= startPos + i; j++) {
                int pos = j + n;
                if (dp[pos][i] > 0) {
                    dp[pos-1][i+1] = (dp[pos-1][i+1] + dp[pos][i]) % 1000000007;

                    dp[pos+1][i+1] = (dp[pos+1][i+1] + dp[pos][i]) % 1000000007;
                }
            }
        }
        return dp[endPos+n][k];
    }
}
