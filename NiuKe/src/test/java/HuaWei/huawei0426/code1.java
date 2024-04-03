package HuaWei.huawei0426;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());

            List<Integer>[] graph = new LinkedList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            int[] indegree = new int[n+1];
            for (int i = 0; i < n; i++) {
                String[] split = in.nextLine().split(" ");
                if (split[0].equals("0")) continue;
                int m = Integer.parseInt(split[0]);
                for (int j = 1; j <= m; j++) {
                    int to = i+1;
                    int from = Integer.parseInt(split[j]);
                    graph[from].add(to);
                    indegree[to]++;
                }
            }

            int count = 0;
            int ans = 0;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    deque.add(i);
                }
            }

            while (!deque.isEmpty()) {
                int len = deque.size();
                ans++;
                for (int i = 0; i < len; i++) {
                    count++;
                    int cur = deque.poll();
                    for (Integer next : graph[cur]) {
                        indegree[next]--;
                        if (indegree[next] == 0) {
                            deque.offer(next);
                        }
                    }
                }
            }
            if (count == n) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }

        }


    }
}
