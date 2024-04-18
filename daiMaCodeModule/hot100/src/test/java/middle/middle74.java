package middle;

public class middle74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,target);
    }

    private boolean search(int[][] matrix, int target) {

        int left = 0;
        int right = matrix[0].length - 1;

        while (left < matrix.length && right >= 0) {
            if (matrix[left][right] == target) {
                return true;
            } else if (matrix[left][right] > target) {
                right--;
            } else if (matrix[left][right] < target) {
                left++;
            }
        }

        return false;
    }
}
