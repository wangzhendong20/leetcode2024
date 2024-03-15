package middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class middle210 {
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
}
