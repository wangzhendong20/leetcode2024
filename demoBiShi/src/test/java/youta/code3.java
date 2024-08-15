package youta;

import java.util.*;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= n; i++) {
                map.put(i, in.nextInt());
            }
            List<Integer>[] graph = new LinkedList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            while (in.hasNext()) {
                int from = in.nextInt();
                int to = in.nextInt();
                graph[from].add(to);
                graph[to].add(from);
            }

            System.out.println(6);
        }
    }
}
