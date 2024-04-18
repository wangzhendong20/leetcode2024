package middle;

import java.util.ArrayList;
import java.util.List;

public class middle54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = Math.min(m,n) / 2;
        int offset = 1;
        int startx = 0, starty = 0;

        while (loop-- > 0) {
            int i = startx;
            int j = starty;
            for (; j < n - offset; j++) {
                ans.add(matrix[i][j]);
            }
            for (; i < m - offset; i++) {
                ans.add(matrix[i][j]);
            }
            for (; j > starty; j--) {
                ans.add(matrix[i][j]);
            }
            for (; i > startx; i--) {
                ans.add(matrix[i][j]);
            }
            startx++;
            starty++;
            offset++;
        }
        if (Math.min(m,n) % 2 == 1) {
            if (m > n) {
                for (int k = 0; k < loop + m - n + 1; k++) {
                    ans.add(matrix[k][loop]);
                }
            } else {
                for (int k = 0; k < loop + m - n + 1; k++) {
                    ans.add(matrix[loop][k]);
                }
            }
        }
        return ans;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        //左闭右闭
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        //上下左右
        int u = 0, d = m - 1, l = 0, r = n - 1;

        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            if (++u > d) break;;

            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) break;

            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            if (--d < u) break;

            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }
}
