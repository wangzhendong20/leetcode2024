package xunfei;

import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long[] ans = new long[n];

            for (int i = 0; i < n; i++) {
                long sum = arr[i];
                int left = i - 1;
                int right = i + 1;
                boolean leftFlag = true;
                boolean rightFlag = true;
                long[] dp = new long[n];
                int index = i;
                dp[index] = sum;
                while (left >= 0 && right < n) {
                    if (!leftFlag || !rightFlag) {
                        break;
                    }
                    if (dp[index] >= arr[left] && dp[index] >= arr[right]) {
                        leftFlag = false;
                        rightFlag = false;
                    } else if (sum >= arr[left] && sum < arr[right]) {
                        leftFlag = false;
                        sum += arr[right];
                        dp[right] = sum;
                        right++;
                    } else if (sum < arr[left] && sum >= arr[right]) {
                        rightFlag = false;
                        sum += arr[left];
                        dp[left] = sum;
                        left--;
                    } else {

                    }
                }
                while (left >= 0) {
                    if (!leftFlag) break;
                    if (sum >= arr[left]) {
                        leftFlag = false;
                    }else if (sum < arr[left]) {
                        sum += arr[left];
                        left--;
                    }
                }
                while (right < n) {
                    if (!rightFlag) break;
                    if (sum >= arr[right]) {
                        rightFlag = false;
                    }else if (sum < arr[right]) {
                        sum += arr[right];
                        right++;
                    }
                }

                ans[i] = sum;
            }


            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.print(ans[i]);
                } else {
                    System.out.print(ans[i] + " ");
                }
            }
        }
    }
}
