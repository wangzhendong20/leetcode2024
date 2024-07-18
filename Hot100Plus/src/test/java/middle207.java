import java.util.LinkedList;
import java.util.List;

public class middle207 {

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        hasCycle = false;

        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
        }

        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void dfs(List<Integer>[] graph, int start) {
        if (onPath[start]) {
            hasCycle = true;
            return;
        }

        if (visited[start] || hasCycle) return;

        visited[start] = true;
        onPath[start] = true;

        for (Integer index : graph[start]) {
            dfs(graph,index);
        }

        onPath[start] = false;
    }
}
