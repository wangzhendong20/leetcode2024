public class middle48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int k = 0, j = n - 1; k < j; k++,j--) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }


        int diff = 1;
        for (int row1 = 0, col2 = n - 1; row1 < n - 1 && col2 > 0; row1++,col2--) {
            for (int col1 = 0, row2 = n - 1; col1 < n - diff && row2 >= diff; col1++,row2--) {
                int temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
            }
            diff++;
        }

    }
}
