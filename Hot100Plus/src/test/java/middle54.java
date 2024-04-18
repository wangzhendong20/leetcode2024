import java.util.ArrayList;
import java.util.List;

public class middle54 {
    /**
     * 54. 螺旋矩阵
     * 模拟，注意边界条件，左闭右开
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int loop = Math.min(rows, cols) / 2;
        int row = 0;
        int col = 0;
        int diff = 1;
        while (loop-- > 0) {
            int i = row;
            int j = col;
            for (; j < cols - diff; j++) {
                res.add(matrix[row][j]);
            }

            for (; i < rows - diff; i++) {
                res.add(matrix[i][j]);
            }

            for (; j > col; j--) {
                res.add(matrix[i][j]);
            }

            for (; i > row; i--) {
                res.add(matrix[i][j]);
            }

            row++;
            col++;
            diff++;
        }

        if (rows % 2 == 1 && cols % 2 == 1) {
            if (rows > cols) {
                for (int i = row; i <= rows - diff; i++) {
                    res.add(matrix[i][col]);
                }
            } else {
                for (int j = col; j <= cols - diff; j++) {
                    res.add(matrix[row][j]);
                }
            }
        } else if (rows % 2 == 1) {
            for (int j = col; j <= cols - diff; j++) {
                res.add(matrix[row][j]);
            }
        } else if (cols % 2 == 1) {
            for (int i = row; i <= rows - diff; i++) {
                res.add(matrix[i][col]);
            }
        }


        return res;
    }
}
