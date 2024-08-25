package bilibili;

import java.util.Scanner;

public class MinimumBending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取礼品盒的数量
        int n = scanner.nextInt();

        // 读取苹果数量
        int[] apples = new int[n];
        for (int i = 0; i < n; i++) {
            apples[i] = scanner.nextInt();
        }

        // 读取糖果数量
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = scanner.nextInt();
        }

        // 计算苹果和糖果的目标数量
        int appleTarget = findTarget(apples);
        int candyTarget = findTarget(candies);

        // 计算苹果和糖果的缺口
        int appleDiff = 0;
        int candyDiff = 0;

        int ans = 0;
        for (int i = 0; i < n; i++) {

            appleDiff = Math.max(0, appleTarget - apples[i]);
            candyDiff = Math.max(0, candyTarget - candies[i]);
            int simultaneousOperations = Math.min(appleDiff, candyDiff);
            // 计算剩余的单独操作
            int singleOperations = (appleDiff - simultaneousOperations)
                    + (candyDiff - simultaneousOperations);

            // 计算总的弯腰次数
            int totalBends = simultaneousOperations + singleOperations;
            ans += totalBends;
        }


        // 输出结果
        System.out.println(ans);

        scanner.close();
    }

    // 计算目标数量（取最大值）
    private static int findTarget(int[] values) {
        int target = 0;
        for (int value : values) {
            target = Math.max(target, value);
        }
        return target;
    }
}
