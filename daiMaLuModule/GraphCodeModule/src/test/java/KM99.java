import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class KM99 {
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

        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(graph, i, j ,visited);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static int[][] dir = {
            {0,1},{1,0},{0,-1},{-1,0}
    };
    private static void dfs(int[][] graph, int x, int y, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
            if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                dfs(graph,nextX,nextY,visited);
            }
        }
    }

    private static void bfs(int[][] graph, int x, int y, boolean[][] visited) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{x,y});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) continue;
                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    deque.add(new int[]{nextX,nextY});
                }
            }
        }
    }
}
