package hard;

public class hard132 {
    public int minCut(String s) {
        boolean[][] isHuiWen = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isHuiWen[i][j] = true;
                    } else if (isHuiWen[i+1][j-1]) {
                        isHuiWen[i][j] = true;
                    }
                }
            }
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }
        for (int i = 1; i < s.length(); i++) {
            if (isHuiWen[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isHuiWen[j+1][i]) {
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[s.length()-1];
    }

}
