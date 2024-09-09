package shunfeng;

import java.util.Scanner;

public class code2 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }
            scanner.close();

            // 记录房屋是否被访问
            boolean[] visited = new boolean[n];
            // 从第一个房屋开始进行DFS
            dfs(values, visited, -1, 0, n);

            // 输出结果
            System.out.println(count);
        }
    }

    private static void dfs(int[] values, boolean[] visited, int lastIndex, int depth, int n) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && (lastIndex == -1 || isMultiple(values[lastIndex], values[i]))) {
                visited[i] = true;
                dfs(values, visited, i, depth + 1, n);
                visited[i] = false;
            }
        }
    }

    private static boolean isMultiple(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
}
