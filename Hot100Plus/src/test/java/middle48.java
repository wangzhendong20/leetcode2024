public class middle48 {
    /**
     * 48. Rotate Image
     * 先中心线对称翻转，再对角线对称翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0, k = n - 1; j < k; j++,k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
        int diff = 1;

        for (int row1 = 0,col2 = n-1; row1 < m-1 && col2 > 0; row1++,col2--) {
            for (int col1 = 0,row2 = m-1; col1 < n-diff && row2 >= diff; col1++,row2--) {
                int temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
            }
            diff++;
        }

    }
}
