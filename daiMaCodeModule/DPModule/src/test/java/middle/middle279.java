package middle;

public class middle279 {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= n/2; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j - i*i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
                }
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(numSquares(n));
    }
}
