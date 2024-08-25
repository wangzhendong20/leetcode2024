package meiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int[] start = new int[2];
            start[0] = in.nextInt();
            start[1] = in.nextInt();
            int[] end = new int[2];
            end[0] = in.nextInt();
            end[1] = in.nextInt();
            int n = in.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                list.add(new int[]{x,y});
            }
            long ans = 0L;

            long[] disStart = new long[n];
            long[] disEnd = new long[n];
            for (int i = 0; i < n; i++) {
                long startlen = Math.abs((long)start[0] - (long)list.get(i)[0]) +
                        Math.abs((long)start[1] - (long)list.get(i)[1]);
                long Endlen = Math.abs((long)end[0] - (long)list.get(i)[0]) +
                        Math.abs((long)end[1] - (long)list.get(i)[1]);
                disStart[i] = startlen;
                disEnd[i] = Endlen;
            }

            long minLen = disStart[0] - disEnd[0];
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                long val = disStart[i] - disEnd[i];
                if (val < minLen) {
                    minIndex = i;
                    minLen = val;
                }
            }

            for (int i = 0; i < n; i++) {
                ans += 2 * disEnd[i];
            }
            ans += minLen;

            System.out.println(ans);
        }
    }
}
