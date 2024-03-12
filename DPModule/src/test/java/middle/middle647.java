package middle;

public class middle647 {
    /**
     * 双指针
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += extend(s,i,i,s.length());
            result += extend(s,i,i+1,s.length());
        }

        return result;
    }

    private int extend(String s, int i, int j, int length) {
        int res = 0;
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }

    /**
     * DP方法
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1){
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;
    }


}
