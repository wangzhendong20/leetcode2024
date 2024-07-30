import java.util.Scanner;

public class KM102 {
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
                    graph[i][j] = 0;
                } else if (graph[i][j] == 2) {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.print(graph[i][m-1]);
            System.out.println();
        }
    }

    static int dir[][] = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static void dfs(int[][] graph, int x, int y) {
        graph[x][y] = 2;
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
