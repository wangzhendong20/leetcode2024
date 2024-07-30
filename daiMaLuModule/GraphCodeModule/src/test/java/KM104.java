import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class KM104 {
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
        int mark = 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean isAllGrid = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) isAllGrid = false;
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(graph,i,j,visited,mark);
                    map.put(mark,count);
                    mark++;
                }
            }
        }

        if (isAllGrid) {
            System.out.println(n*m);
            return;
        }

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 1;
                set.clear();
                if (graph[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nearX = i + dir[k][0];
                        int nearY = j + dir[k][1];
                        if (nearX < 0 || nearY < 0 || nearX >= n || nearY >= m) continue;
                        if (set.contains(graph[nearX][nearY])) continue;
                        if (graph[nearX][nearY] == 0) continue;
                        count += map.get(graph[nearX][nearY]);
                        set.add(graph[nearX][nearY]);
                    }
                }

                res = Math.max(res,count);
            }
        }

        System.out.println(res);

    }

    static int[][] dir = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    static int count;

    private static void dfs(int[][] graph, int x, int y, boolean[][] visited, int mark) {
        if (visited[x][y] || graph[x][y] == 0) return;
        visited[x][y] = true;
        graph[x][y] = mark;
        count++;
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) continue;
            if (visited[nx][ny]) continue;
            dfs(graph,nx,ny,visited,mark);
        }
    }

}
