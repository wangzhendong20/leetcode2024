public class middle59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int loop = n / 2;
        int offset = 1;
        int num = 1;
        int mid = n / 2;
        int startx = 0, starty = 0;
        int i,j;
        while (loop-- > 0) {

            i = startx;
            j = starty;

            for (; j < n - offset; j++) {
                ans[i][j] = num++;
            }

            for (; i < n - offset; i++) {
                ans[i][j] = num++;
            }

            for (; j > starty; j--) {
                ans[i][j] = num++;
            }

            for (; i > startx; i--) {
                ans[i][j] = num++;
            }

            offset++;
            startx++;
            starty++;
        }

        if (n % 2 == 1) {
            ans[mid][mid] = num;
        }

        return ans;
    }
}
