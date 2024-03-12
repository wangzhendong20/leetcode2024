package simple;

public class simple392 {
    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        int slow = 0;

        for (int fast = 0; fast < t.length(); fast++) {
            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
            }
            if (slow == s.length()) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
