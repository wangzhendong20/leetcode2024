package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class dfsCard {
    /**
     * dfs模板，对应题目leetcode797
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph,0);
        return res;
    }

    private void dfs(int[][] graph, int x) {
        if (x == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[x].length; i++) {
            path.add(graph[x][i]);
            dfs(graph,graph[x][i]);
            path.removeLast();
        }
    }
}
