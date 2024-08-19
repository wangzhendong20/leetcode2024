import java.util.Deque;
import java.util.LinkedList;

public class middle785 {
    class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            else return parent[x] = find(parent[x]);
        }

        public boolean isSame(int x, int y) {
            return find(x) == find(y);
        }

        public void join(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            parent[y] = x;
        }

    }

    /**
     * 并查集
     * 我们知道如果是二分图的话，那么图中每个顶点的所有邻接点都应该属于同一集合，且不与顶点处于同一集合。
     * 因此我们可以使用并查集来解决这个问题，
     * 我们遍历图中每个顶点，将当前顶点的所有邻接点进行合并，并判断这些邻接点中是否存在某一邻接点已经和当前顶点处于同一个集合中了，
     * 若是，则说明不是二分图。
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        UF uf = new UF(graph.length);

        // 遍历每个顶点，将当前顶点的所有邻接点进行合并
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];
            for (int adj : adjs) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (uf.isSame(i, adj)) {
                    return false;
                }
                uf.join(adjs[0], adj);
            }
        }

        return true;
    }

    /**
     * DFS
     * 我们使用图搜索算法从各个连通域的任一顶点开始遍历整个连通域，遍历的过程中用两种不同的颜色对顶点进行染色，相邻顶点染成相反的颜色。
     * 这个过程中倘若发现相邻的顶点被染成了相同的颜色，说明它不是二分图；反之，如果所有的连通域都染色成功，说明它是二分图。
     * @param graph
     * @return
     */
    public boolean isBipartite2(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] visited, int u, int color) {
        // 如果要对某顶点染色时，发现它已经被染色了，则判断它的颜色是否与本次要染的颜色相同，如果矛盾，说明此无向图无法被正确染色，返回 false。
        if (visited[u] != 0) {
            return visited[u] == color;
        }

        // 对当前顶点进行染色，并将当前顶点的所有邻接点染成相反的颜色。
        visited[u] = color;
        for (int w : graph[u]) {
            if (!dfs(graph,visited,w,color)) {
                return false;
            }
        }
        return true;
    }

    /**
     * BFS
     * @param graph
     * @return
     */
    public boolean isBipartite3(int[][] graph) {
        // 定义 visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
        int[] visited = new int[graph.length];
        Deque<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w : graph[v]) {
                    // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        queue.offer(w);
                    }
                }
            }
        }

        return true;
    }
}
