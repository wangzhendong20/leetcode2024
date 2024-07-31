package base;

import java.util.*;

public class SPFA {
    static class Edge {
        int to;
        int val;
        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++) {
            int form = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            graph.get(form).add(new Edge(to, val));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Edge edge : graph.get(cur)) {
                int from = cur;
                int to = edge.to;
                int val = edge.val;
                if (minDist[to] > minDist[from] + val) {
                    minDist[to] = minDist[from] + val;
                    queue.add(to);
                }
            }
        }

        if (minDist[end] == Integer.MAX_VALUE) System.out.println("unconnected");
        else System.out.println(minDist[end]);

    }
}
