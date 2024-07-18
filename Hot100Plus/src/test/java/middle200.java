import java.util.Deque;
import java.util.LinkedList;

public class middle200 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];
            int cury = cur[1];
            for (int[] d : directions) {
                int nx = curx + d[0];
                int ny = cury + d[1];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                if (grid[nx][ny] == '1' && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
