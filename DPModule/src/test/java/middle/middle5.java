package middle;

public class middle5 {
    /**
     * 双指针法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int start = 0;
        int maxlen = 1;

        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s,i,i,s.length());
            int len2 = extend(s,i,i+1,s.length());
            int len = Math.max(len1,len2);
            if (maxlen < len) {
                maxlen = len;
                start = i - (maxlen - 1) / 2;
            }
        }

        return s.substring(start,start+maxlen);
    }

    private int extend(String s, int left, int right, int length) {
        int len = 1;

        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }

        return len;
    }


    /**
     * DP
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlen = 1;
        int start = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i+1][j-1]) {
                            dp[i][j] = true;
                        }
                    }
                }

                if (dp[i][j] && maxlen < j - i + 1) {
                    maxlen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxlen);

    }

}
