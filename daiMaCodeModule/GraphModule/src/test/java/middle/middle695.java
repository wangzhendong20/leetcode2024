package middle;

public class middle695 {
    int[][] dir = {
            {0,1},{0,-1},{1,0},{-1,0}
    };
    int sum;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    sum = 1;
                    visited[i][j] = true;
                    dfs(grid,visited,i,j);
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (!visited[nextx][nexty] && grid[nextx][nexty] == 1) {
                visited[nextx][nexty] = true;
                sum++;
                dfs(grid,visited,nextx,nexty);
            }
         }
    }
}
