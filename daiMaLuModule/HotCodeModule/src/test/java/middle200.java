public class middle200 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, i, j, visited);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || visited[newX][newY]) continue;
            if (grid[newX][newY] == '1') {
                visited[newX][newY] = true;
                dfs(grid, newX, newY, visited);
            }
        }

    }
}
