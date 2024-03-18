package middle;

public class middle48 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            for (int i = 0; i < len; i++) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
            }
            left++;
            right--;
        }

        int lenCol = len - 2;
        for (int i = 0; i <= len - 2; i++) {
            for (int j = 0; j <= lenCol; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][len - i -1];
                matrix[len - j -1][len - i - 1] = tmp;
            }
            lenCol--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}
        };
        rotate(matrix);
    }
}
