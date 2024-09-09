package ningmeng;

import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 动态规划数组，dp[j] 表示和为 j 的组合数
        int[] dp = new int[s + 1];
        dp[0] = 1;  // 和为 0 时，有一种组合方式，即空集

        // 遍历每个数并更新 dp 数组
        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        // 输出结果
        System.out.println(dp[s]);
    }
}

