public class middle647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                        count++;
                    } else if (dp[i+1][j-1]) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return count;
    }

    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += entend(s,i,i,dp);
            count += entend(s,i,i+1,dp);
        }
        return count;

    }

    private int entend(String s, int left, int right, boolean[][] dp) {
        if (left > right) return 0;
        int count = 0;
        for (int i = left,j = right; i >= 0 && j < s.length(); i--,j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i < 2) {
                    dp[i][j] = true;
                    count++;
                } else if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            } else {
                break;
            }
        }
        return count;
    }

}
