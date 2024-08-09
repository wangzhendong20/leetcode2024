public class middle5 {
    public String longestPalindrome(String s) {
        if (s.length() < 1) return s;
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i,i);
            int len2 = extend(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int extend(String s, int left, int right) {
        int len = 1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }

        return len;
    }

    public String longestPalindrome2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
