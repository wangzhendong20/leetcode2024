import java.util.Scanner;

public class KM103 {
    static int[][] dir = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static void dfs(int[][] graph, int x, int y, boolean[][] visited) {
        if (visited[x][y]) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) continue;
            if (graph[x][y] > graph[nx][ny]) continue;

            dfs(graph,nx,ny,visited);
        }

    }

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
        boolean[][] visited1 = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(graph,i,0,visited1);
            dfs(graph,i,m-1,visited2);
        }

        for (int j = 0; j < m; j++) {
            dfs(graph,0,j,visited1);
            dfs(graph,n-1,j,visited2);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }

    }

}
