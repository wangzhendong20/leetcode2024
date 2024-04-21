package lc394th;

import java.util.*;

public class code100276 {
    public static boolean[] findAnswer(int n, int[][] edges) {
        boolean[] ans = new boolean[edges.length];

        LinkedList<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            int weight = edge[2];

            graph[from].add(new int[]{from, to, weight});

            from = edge[1];
            to = edge[0];
            weight = edge[2];
            graph[from].add(new int[]{from, to, weight});
        }

        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[0] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 start 开始进行 BFS
        pq.offer(new State(0, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] edge : graph[curNodeID]) {
                int nextNodeID = edge[1];
                int weight = edge[2];
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = distTo[curNodeID] + weight;
                if (distTo[nextNodeID] > distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }

            int lastDist = distTo[n-1];
            boolean[] visited = new boolean[n];
            if (lastDist != Integer.MAX_VALUE) {
                // 找到了最短路径，开始回溯
                dfs(graph, visited, 0, lastDist, 0, n-1);
            }
            HashSet<int[]> set = new HashSet<>();
            for (LinkedList<int[]> allPath : allPaths) {
                for (int[] ints : allPath) {
                    set.add(ints);
                }
            }

            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0], to = edges[i][1];
                int weight = edges[i][2];
                List<int[]> newEdges = Arrays.asList(new int[]{to, from, weight});
                if (set.contains(Arrays.asList(edges[i])) || set.contains(newEdges) ) {
                    ans[i] = true;
                }
            }

        }

        return ans;

    }

    static LinkedList< LinkedList<int[]>> allPaths = new LinkedList<>();
    static LinkedList<int[]> path = new LinkedList<>();

    private static void dfs(LinkedList<int[]>[] graph, boolean[] visited, int dist, int lastDist, int node, int lastNode) {
        if (dist == lastDist && node == lastNode) {
            allPaths.add(new LinkedList<>(path));
            return;
        }
        if (node == lastNode) {
            return;
        }

        if (visited[node]) return;

        visited[node] = true;
        for (int[] edge : graph[node]) {
            int nextNode = edge[1];
            int weight = edge[2];
            path.add(new int[]{node, nextNode, weight});
            dfs(graph, visited, dist + weight, lastDist, nextNode, lastNode);
            path.removeLast();
        }
        visited[node] = false;
    }


    static class State {
        // 图节点的 id
        private int id;
        // 从 start 节点到当前节点的距离
        private int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1,4},{0,2,1}, {1,3,2}, {1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};

        boolean[] ans = findAnswer(n, edges);
        for (boolean b : ans) {
            System.out.print(b + " ");
        }
        System.out.println();

    }
}
