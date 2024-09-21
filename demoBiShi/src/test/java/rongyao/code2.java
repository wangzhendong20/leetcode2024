package rongyao;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int M = in.nextInt();
            int[] goods = new int[M];
            int sum = 0;
            for (int i = 0; i < M; i++) {
                goods[i] = in.nextInt();
                sum += goods[i];
            }

            int capa = sum / 2;
            int[] dp = new int[capa + 1];
            for (int i = 0; i < M; i++) {
                for (int j = capa; j >= goods[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - goods[i]] + goods[i]);
                }
            }

            System.out.println(Math.max(dp[capa], sum - dp[capa]));
        }
    }

}
