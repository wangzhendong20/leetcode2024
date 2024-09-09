package xieCheng;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            char[] chars = in.next().toCharArray();
            int count = 0;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                if (chars[i] == chars[i-1]) {
                    dp[i] = dp[i-1];
                } else {
                    dp[i] = dp[i-1] + 1;
                }
            }
            for (int i = 1; i <= n; i+=2) {
                for (int j = i-1; j < n; j++) {
                    if (dp[j] - dp[j-i+1] == 0) {
                        if (chars[j] == '0') {
                            count++;
                        }
                    } else {
                        int k = j;
                        while(chars[k] != '0') {
                            k--;
                        }
                        if ((dp[k] - dp[j-i+1] + 1) % 2 == 1) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

}
