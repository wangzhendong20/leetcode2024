package xiaohongshu;

import java.util.Scanner;

public class MinimalAesthetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 读取物品数量
        int[] types = new int[n];   // 存储物品类别
        int[] movable = new int[n]; // 存储物品是否可移动

        // 读取物品类别
        for (int i = 0; i < n; i++) {
            types[i] = scanner.nextInt();
        }

        // 读取物品是否可移动
        for (int i = 0; i < n; i++) {
            movable[i] = scanner.nextInt();
        }

        // 计算最小的不美观程度
        int minAesthetic = calculateMinAesthetic(types, movable, n);

        // 输出最小的不美观程度
        System.out.println(minAesthetic);
    }

    // 计算最小的不美观程度
    private static int calculateMinAesthetic(int[] types, int[] movable, int n) {
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            original[i] = types[i];
        }

        // 计算原始不美观程度
        int currentAesthetic = 0;
        for (int i = 1; i < n; i++) {
            if (types[i] != types[i - 1]) {
                currentAesthetic++;
            }
        }

        // 计算不美观程度的最小值
        int minAesthetic = currentAesthetic;

        // 遍历所有可能的交换
        for (int i = 0; i < n; i++) {
            if (movable[i] == 1) {
                // 尝试将当前物品移动到所有其他位置
                for (int j = 0; j < n; j++) {
                    if (i != j && movable[j] == 1) {
                        // Swap elements i and j
                        int temp = types[i];
                        types[i] = types[j];
                        types[j] = temp;

                        // 计算新的不美观程度
                        int newAesthetic = 0;
                        for (int k = 1; k < n; k++) {
                            if (types[k] != types[k - 1]) {
                                newAesthetic++;
                            }
                        }

                        // 更新最小不美观程度
                        minAesthetic = Math.min(minAesthetic, newAesthetic);

                        // Restore original order
                        temp = types[i];
                        types[i] = types[j];
                        types[j] = temp;
                    }
                }
            }
        }

        return minAesthetic;
    }
}
