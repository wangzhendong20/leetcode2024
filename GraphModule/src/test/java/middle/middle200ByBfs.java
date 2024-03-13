package middle;


import java.util.Deque;
import java.util.LinkedList;

public class middle200ByBfs {

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    bfs(grid,visited, i, j);
                }
            }
        }
        return res;
    }

    //将这片岛屿上的所有陆地都访问到
    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];
            int cury = cur[1];
            for(int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][0];
                int nexty = cury + dir[i][1];
                if(nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                if(!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                    queue.offer(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true; //只要加入队列就标记为访问
                }
            }
        }
    }
}
