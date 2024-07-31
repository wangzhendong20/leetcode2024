package base;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], 10005);
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        // 开始 floyd
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int num = scanner.nextInt();
        while (num-- > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (graph[start][end] == 10005) System.out.println(-1);
            else System.out.println(graph[start][end]);
        }

    }
}
