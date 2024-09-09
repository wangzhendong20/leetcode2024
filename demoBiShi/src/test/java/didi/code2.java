package didi;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        String s = scanner.next();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = arr[s.charAt(i)-'a'][s.charAt(i+1)-'a'];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                for (int m = i + 1; m < j; m+=2) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][m] + dp[m+1][j]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + arr[s.charAt(i)-'a'][s.charAt(j)-'a']);
            }
        }


        System.out.println(dp[0][n-1]);
    }
}
