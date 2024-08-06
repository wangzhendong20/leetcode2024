import java.util.ArrayList;
import java.util.List;

public class middle54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        int m = matrix.length, n = matrix[0].length;
        int loop = Math.min(m,n) / 2;
        int diff = 1;
        int row = 0;
        int col = 0;

        while(loop-- > 0){

            int i = row;
            int j = col;

            for (; j < n - diff; j++) {
                res.add(matrix[row][j]);
            }

            for (; i < m - diff; i++) {
                res.add(matrix[i][j]);
            }

            for (; j >= diff; j--) {
                res.add(matrix[i][j]);
            }

            for (; i >= diff; i--) {
                res.add(matrix[i][j]);
            }

            row++;
            col++;
            diff++;
        }

        if (m % 2 == 1 && n % 2 == 1) {
            if (m > n) {
                for (int i = row; i <= m - diff; i++) {
                    res.add(matrix[i][col]);
                }
            } else {
                for (int j = col; j <= n - diff; j++) {
                    res.add(matrix[row][j]);
                }
            }
        } else if (m % 2 == 1) {
            for (int j = col; j <= n - diff; j++) {
                res.add(matrix[row][j]);
            }
        } else if (n % 2 == 1) {
            for (int i = row; i <= m - diff; i++) {
                res.add(matrix[i][col]);
            }
        }

        return res;
    }
}
