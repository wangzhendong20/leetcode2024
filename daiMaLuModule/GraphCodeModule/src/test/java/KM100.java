import java.util.Scanner;

public class KM100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int maxCount = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    dfs(graph, i, j, visited);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        System.out.println(maxCount);
    }

    static int[][] dir = {
            {0, 1},{0, -1},{1, 0},{-1, 0}
    };
    static int count = 0;

    private static void dfs(int[][] graph, int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                count++;
                dfs(graph, nextX, nextY, visited);
            }
        }
    }
}
