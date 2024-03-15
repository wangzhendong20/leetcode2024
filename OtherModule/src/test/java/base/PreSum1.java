package base;

public class PreSum1 {
    /**
     * 一维前缀和模板
     */
    class NumMatrix {
        private int[] preSum;

        public NumMatrix(int[] matrix) {
            preSum = new int[matrix.length + 1];
            for (int i = 0; i < matrix.length; i++) {
                preSum[i+1] = preSum[i] + matrix[i];
            }
        }

        public int sumRegion(int i, int j) {
            return preSum[j+1] - preSum[i];
        }
    }
}
