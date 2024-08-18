package dajiang;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] graph = new ArrayList[10005];
        int[] degree = new int[10005];
        for (int i = 0; i < 10005; i++) {
            graph[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            graph[from].add(to);
            degree[to]++;
            max = Math.max(max, Math.max(from,to));
        }

        for (int i = 0; i < 10005; i++) {
            Collections.sort(graph[i]);
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            if (degree[i] == 0) {
                deque.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();

        while (!deque.isEmpty()) {
            int node = deque.poll();
            res.add(node);
            for (int next: graph[node]) {
                degree[next]--;
                if (degree[next] == 0) {
                    deque.add(next);
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if(i < res.size() - 1) {
                System.out.print(" ");
            }
        }

    }
}
