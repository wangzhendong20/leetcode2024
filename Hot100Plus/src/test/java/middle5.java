public class middle5 {

    /**
     * 双指针，从中心往两边扩展，找到最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int start = 0;
        int maxlen = 1;

        for (int i = 0; i < s.length()-1; i++) {
            int len1 = extend(s,i,i);
            int len2 = extend(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > maxlen) {
                start = i - (len-1)/2;
                maxlen = len;
            }
        }

        return s.substring(start,start+maxlen);

    }

    private int extend(String s, int left, int right) {
        int len = 1;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len = right - left + 1;
            left--;
            right++;
        }
        return len;
    }

    /**
     * DP
     * dp[i][j] 表示 s[i...j] 是否为回文串
     * if (s.charAt(i) == s.charAt(j)) 的时候分为三种情况：
     * 1. j - i = 0，即只有一个字符，肯定是回文串
     * 2. j - i = 1，即只有两个字符，肯定是回文串
     * 3. s[i+1...j-1] 也是回文串，则 s[i...j] 也是回文串
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxlen = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && (j - i + 1 > maxlen)) {
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }

        return s.substring(start, start+maxlen);
    }
}
