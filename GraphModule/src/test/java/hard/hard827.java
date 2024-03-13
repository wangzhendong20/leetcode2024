package hard;

import java.util.HashMap;
import java.util.HashSet;

public class hard827 {
    int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
    };
    int count;
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int mark = 2;
        boolean isAllGrid = true;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) isAllGrid = false;
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = 1;
                    visited[i][j] = true;
                    grid[i][j] = mark;
                    dfs(grid,visited,i,j,mark);
                    map.put(mark,count);
                    mark++;
                }
            }
        }

        if (isAllGrid) return m*n;

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 1;
                set.clear();
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextx = i + dir[k][0];
                        int nexty = j + dir[k][1];
                        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                        if (map.containsKey(grid[nextx][nexty]) && !set.contains(grid[nextx][nexty])){
                            sum += map.get(grid[nextx][nexty]);
                            set.add(grid[nextx][nexty]);
                        }
                    }
                }
                res = Math.max(res,sum);
            }
        }
        return res;
    }


    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int mark){
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (grid[nextx][nexty] == 1) {
                visited[nextx][nexty] = true;
                grid[nextx][nexty] = mark;
                count++;
                dfs(grid,visited,nextx,nexty,mark);
            }
        }
    }

}
