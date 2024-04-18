package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class middle417 {
    int[][] dir = {
            {0,1},{0,-1},{1,0},{-1,0}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAtl = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(heights,isPac,i,0);
            dfs(heights,isAtl,i,n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights,isPac,0,i);
            dfs(heights,isAtl,m-1,i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPac[i][j] && isAtl[i][j]) res.add(List.of(i,j));
            }
        }
        return res;
    }


    private void dfs(int[][] height, boolean[][] visited, int x, int y) {
        if (visited[x][y]) return;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= height.length || nexty < 0 || nexty >= height[0].length) continue;
            if (height[x][y] > height[nextx][nexty]) continue;
            dfs(height,visited,nextx,nexty);
        }
    }
}
