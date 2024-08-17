package mihayou;

import java.util.*;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[m][2];
            int[] diff = new int[n + 1];
            for (int i = 0; i < m; i++) {
                arr[i][0] = in.nextInt() - 1;
                arr[i][1] = in.nextInt() - 1;
                diff[arr[i][0]]++;
                if (arr[i][1] < n - 1) {
                    diff[arr[i][1] + 1]--;
                }
            }


            int[] road = new int[n+1];
            road[0] = diff[0];
            for (int i = 1; i <= n; i++) {
                road[i] = road[i-1] + diff[i];
            }

            int[] preSum = new int[n+1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i-1] + (road[i-1] == 1 ? 1 : 0);
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                int start = arr[i][0];
                int end = arr[i][1];
                int oneRan = preSum[end+1] - preSum[start];
                int len = end - start + 1;
                if (oneRan != len) {
                    res++;
                }
            }

            System.out.println(res);
        }
    }
}
