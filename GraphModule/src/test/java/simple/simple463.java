package simple;

public class simple463 {
    public static int islandPerimeter(int[][] grid) {
        int[][] dir = {
                {1,0},{-1,0},{0,1},{0,-1}
        };
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nextx = i + dir[k][0];
                        int nexty = j + dir[k][1];
                        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) {
                            len++;
                            continue;
                        }
                        if (grid[nextx][nexty] == 0) {
                            len++;
                        }
                    }
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0},{1,1,1,0}, {0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1,1}};
        System.out.println(islandPerimeter(grid));
    }
}
