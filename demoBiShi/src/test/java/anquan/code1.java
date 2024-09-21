package anquan;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] xNums = new int[n];
        int[] yNums = new int[n];
        for (int i = 0; i < n; i++) {
            xNums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            yNums[i] = scanner.nextInt();
        }

        System.out.println(maxCount(n, k, xNums, yNums));

    }

    private static int maxCount(int n, int k, int[] xNums, int[] yNums) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distance(xNums[i], yNums[i], xNums[j], yNums[j]) <= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                maxCount = Math.max(maxCount, bfs(graph,i,visited));
            }
        }

        return maxCount;
    }

    private static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    private static int bfs(List<List<Integer>> graph, int start, boolean[] used) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(start);
        used[start] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!used[next]) {
                    used[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }

        return count;
    }

}
