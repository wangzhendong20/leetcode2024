package middle;

public class middle1020 {
    int[][] dir = {
            {0,1},{0,-1},{1,0},{-1,0}
    };
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(grid,i,0);
            if (grid[i][n-1] == 1) dfs(grid,i,n-1);
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) dfs(grid,0,i);
            if (grid[m-1][i] == 1) dfs(grid,m-1,i);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (grid[nextx][nexty] == 1) {
                dfs(grid,nextx,nexty);
            }
        }
    }
}
