package middle;

public class middle200ByDfs {
    int[][] dir = {
            {0,1},{1,0},{-1,0},{0,-1}
    };
    public int numIslands(char[][] grid) {
        int m  = grid.length;;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    res++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                visited[nextx][nexty] = true;
                dfs(grid, visited, nextx, nexty);
            }
        }
    }
}
