package middle;

public class middle59 {
    public int[][] generateMatrix(int n) {
        //左闭右开
        int[][] ans = new int[n][n];
        int startx = 0, starty = 0;
        int loop = n/2;  //需要循环n/2次，因为是n/2层
        int count = 1;
        int offset = 1; //记录偏移，即层数
        while (loop-- > 0) {
            int i = startx;
            int j = starty;
            for (; j < n - offset; j++) {
                ans[i][j] = count;
                count++;
            }

            for (; i < n - offset; i++) {
                ans[i][j] = count;
                count++;
            }

            for (; j > starty; j--) {
                ans[i][j] = count;
                count++;
            }

            for (; i > startx; i--) {
                ans[i][j] = count;
                count++;
            }

            startx++;
            starty++;
            offset++;
        }
        if (n % 2 != 0) {
            ans[n/2][n/2] = count;
        }
        return ans;
    }
}
