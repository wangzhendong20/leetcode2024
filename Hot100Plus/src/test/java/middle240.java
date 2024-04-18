public class middle240 {
    /**
     * 240. 搜索二维矩阵 II
     * 方法一：从右上角开始找，如果当前值大于target，则向左移动，如果当前值小于target，则向下移动。
     * 方法二：对于每一行采用二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
