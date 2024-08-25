package meiTuan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long k = in.nextLong();
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(a);
            priorityQueue.add(b);
            priorityQueue.add(c);
            while (k > 0) {
                long min = priorityQueue.poll();
                long nextMin = priorityQueue.peek();
                long max = nextMin - min;
                if (k <= max) {
                    min += k;
                    k = 0;
                } else {
                    min = nextMin;
                    k -= max;
                }

                priorityQueue.add(min);
            }
            long ans = 1L;
            while (!priorityQueue.isEmpty()) {
                ans *= (priorityQueue.poll() % 1000000007);
            }
//            ans = ans % 1000000007;
            System.out.println(ans);
        }
    }
}
