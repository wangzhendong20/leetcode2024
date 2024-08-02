public class middle3128 {

    /**
     * 前缀和
     * 记录每行和每列的1的个数
     * @param grid
     * @return
     */
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long count = 0;

        long[] rowNum = new long[m]; // 记录每行1的个数
        long[] colNum = new long[n]; // 记录每列1的个数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowNum[i]++;
                    colNum[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 减1是因为当前位置不算在内
                    long row = rowNum[i] - 1;
                    long col = colNum[j] - 1;
                    if (row > 0 && col > 0) {
                        count += row * col;
                    }
                }
            }
        }

        return count;
    }
}
