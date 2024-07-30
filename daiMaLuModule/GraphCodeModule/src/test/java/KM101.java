import java.util.Scanner;

public class KM101 {
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

        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (graph[0][j] == 1) {
                dfs(graph,0,j);
            }
            if (graph[n-1][j] == 1) {
                dfs(graph,n-1,j);
            }
        }

        for (int i = 0; i < n; i++) {
            if (graph[i][0] == 1) {
                dfs(graph,i,0);
            }
            if (graph[i][m-1] == 1) {
                dfs(graph,i,m-1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static int dir[][] = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static void dfs(int[][] graph, int x, int y) {
        graph[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) continue;
            if (graph[nx][ny] == 1) {

                dfs(graph,nx,ny);
            }
        }
    }
}
