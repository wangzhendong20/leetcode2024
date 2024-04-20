package base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class middle207 {
    /**
     * 207. 课程表
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
     *
     *
     * 采用邻接表建立的图
     */

    boolean[] visited;  //是否访问过该节点
    boolean[] onPath;  //// 记录一次递归堆栈中的节点  记录当前 dfs 经过的路径
    boolean hasCycle = false; // 记录图中是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            dfs(graph,i);
        }
        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 添加一条从 from 指向 to 的有向边
            // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
            graph[from].add(to);
        }
        return graph;
    }

    /**
     * dfs
     * @param graph
     * @param s
     */
    private void dfs(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            //发现有环
            hasCycle = true;
        }
        // 从节点 s 开始 DFS 遍历，将遍历过的节点标记为 true
        if (visited[s] || hasCycle) return;

        // 将节点 s 标记为已遍历
        visited[s] = true;
        // 开始遍历节点 s
        onPath[s] = true;
        for (Integer t : graph[s]) {
            dfs(graph, t);
        }
        // 节点 s 遍历完成
        onPath[s] = false;
    }

    /**
     * bfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        // 建图，有向边代表「被依赖」关系
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 节点 to 的入度加一
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点 i 没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                q.offer(i);

            }
        }

        // 记录遍历的节点个数
        int count = 0;
        // 开始执行 BFS 循环
        while (!q.isEmpty()) {
            // 弹出节点 cur，并将它指向的节点的入度减一
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {

                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    q.offer(next);
                }
            }
        }

        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }
}
