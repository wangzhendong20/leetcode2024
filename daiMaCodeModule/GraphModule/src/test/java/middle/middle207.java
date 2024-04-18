package middle;

import java.util.LinkedList;
import java.util.List;

public class middle207 {

    boolean[] visited;  //是否访问过该节点
    boolean[] onPath;  //// 记录一次递归堆栈中的节点  记录当前 traverse 经过的路径
    boolean hasCycle = false; // 记录图中是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traversal(graph,i);
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

    private void traversal(List<Integer>[] graph, int s) {
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
            traversal(graph, t);
        }
        // 节点 s 遍历完成
        onPath[s] = false;
    }
}
