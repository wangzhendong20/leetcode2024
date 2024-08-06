public class middle73 {
    /**
     * 先记录第一行和第一列是否有0，进行标记
     * 之后遍历矩阵，如果该元素为0，则将该元素所在行头和列头的标记置为0
     * 之后填充矩阵，如果该元素所在行头或列头的标记为0，则将该元素置为0
     * 最后根据第一行和第一列的标记，将对应的行或列置为0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean flagRow = false;
        boolean flagCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

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

        if (flagRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flagCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
