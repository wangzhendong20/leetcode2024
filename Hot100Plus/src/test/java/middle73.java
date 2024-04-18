public class middle73 {
    /**
     * 73.矩阵置零
     * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。
     * 但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。
     * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
     *
     * 在实际代码中，我们首先预处理出两个标记变量，
     * 接着使用其他行与列去处理第一行与第一列，
     * 然后反过来使用第一行与第一列去更新其他行与列，
     * 最后使用两个标记变量更新第一行与第一列即可。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagRow = false;
        boolean flagCol = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (flagRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
