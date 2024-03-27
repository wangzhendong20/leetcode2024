import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(s);
            String[] str = s.split(",");

            int ans = LSC(str[0],str[1]);
            System.out.println(ans);
        }
    }

    /**
     * 最长公共子串长度
     * @param s1
     * @param s2
     * @return
     */
    private static int LSC(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int[][] dp = new int[s1.length()][s2.length()];

        int ans = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }

        return ans;
    }

}
