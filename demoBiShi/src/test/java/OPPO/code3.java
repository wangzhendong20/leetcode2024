package OPPO;

import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            int[][] dp = new int[n+1][3];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i-1) == '?') {
                    for (int j = 0; j <= 9; j++) {
                        for (int k = 0; k < 3; k++) {
                            dp[i][(k + j) % 3] = (dp[i][(k + j) % 3] + dp[i-1][k]) % 1000000007;
                        }
                    }
                } else {
                    int num = s.charAt(i-1) - '0';
                    for (int j = 0; j < 3; j++) {
                        dp[i][(j + num) % 3] = (dp[i][(j + num) % 3] + dp[i-1][j]) % 1000000007;
                    }
                }
            }
            System.out.println(dp[n][0]);
        }
    }

    static long ans = 0L;
    private static void backtrack(int n, int sum, int diff) {
        if (diff == 0 && sum % 3 == 0) {
            ans++;
            return;
        }

        if (diff == 0) {
            return;
        }

        for (int i = 0; i <= 9; i++) {
            sum += i;
            diff--;
            backtrack(n, sum, diff);
            diff++;
            sum -= i;
        }
    }
}
