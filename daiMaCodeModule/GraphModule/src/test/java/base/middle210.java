package base;

import java.util.*;

public class middle210 {
    /**
     * 210.课程表 II
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * 采用邻接表建立的图
     */
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    List<Integer> path = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            dfs(graph,i);
        }

        if (hasCycle) return new int[]{};
        Collections.reverse(path); // 将后序遍历的结果进行反转，就是拓扑排序的结果。


        int[] res = path.stream().mapToInt(Integer::intValue).toArray();

        return res;

    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void dfs(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
            return;
        }

        if (visited[s] || hasCycle) return;

        visited[s] = true;
        onPath[s] = true;

        for (Integer x : graph[s]) {
            dfs(graph,x);
        }
        path.add(s);   //访问完添加
        onPath[s] = false;
    }

    /**
     * BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        // 建图，和环检测算法相同
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 计算入度，和环检测算法相同
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点，和环检测算法相同
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        // 记录遍历节点的顺序（索引）
        int count = 0;
        // 开始执行 BFS 算法
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count != numCourses) {
            // 存在环，拓扑排序不存在
            return new int[]{};
        }

        return res;
    }
}
