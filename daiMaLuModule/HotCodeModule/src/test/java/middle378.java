import java.util.PriorityQueue;

public class middle378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i , 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            if (y + 1 < n) {
                pq.offer(new int[]{x, y+1});
            }
        }

        int[] minK = pq.peek();
        return matrix[minK[0]][minK[1]];
    }

    class Solution {
        /**
         * 二分查找
         * 大于mid的都在右下方，小于mid的都在左上方
         * 判断当前的mid有多少个元素小于等于mid，如果小于k，说明mid太小，需要增大，反之，说明mid太大，需要减小
         * @param matrix
         * @param k
         * @return
         */
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0];
            int right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (check(matrix, mid, k, n)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 从左下方开始数元素
         * @param matrix
         * @param mid
         * @param k
         * @param n
         * @return
         */
        public boolean check(int[][] matrix, int mid, int k, int n) {
            int i = n - 1;
            int j = 0;
            int num = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    num += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return num >= k;
        }
    }
}
