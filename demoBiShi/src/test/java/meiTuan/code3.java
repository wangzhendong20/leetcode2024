package meiTuan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[] date = new int[m];
            for (int i = 0; i < m; i++) {
                date[i] = in.nextInt();
            }
            int[] lei = new int[m];
            for (int i = 0; i < m; i++) {
                lei[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                int want = in.nextInt();
                int count = in.nextInt();
                PriorityQueue<int[]> pq = new PriorityQueue<>();
                for (int j = l; j <= r; j++) {
                    pq.offer(new int[]{date[j], lei[j]});
                }
                int[] res = new int[count];
                int index = 0;
                while (!pq.isEmpty() && count-- > 0) {

                }

            }

        }
    }
}
