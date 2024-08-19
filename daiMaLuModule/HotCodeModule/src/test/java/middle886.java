import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle886 {
    /**
     * BFS
     * 这题实质也是判断是否构成二分图（以每个人为顶点，以“不喜欢”为边，即若 A 不喜欢 B，则在 A 与 B 之间建边）。
     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] visited = new int[n+1];
        Deque<Integer> deque = new LinkedList<>();
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] =  new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            deque.offer(i);
            visited[i] = 1;
            while (!deque.isEmpty()) {
                int v = deque.poll();
                for (int w : graph[v]) {
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        deque.offer(w);
                    }
                }
            }
        }

        return true;
    }
}
