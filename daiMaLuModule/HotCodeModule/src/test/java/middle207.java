import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class middle207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<LinkedList<Integer>> graph = buildGraph(numCourses, prerequisites, indegree);

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            res.add(cur);
            for (Integer index : graph.get(cur)) {
                indegree[index]--;
                if (indegree[index] == 0) {
                    deque.add(index);
                }
            }
        }

        if (res.size() == numCourses) {
            return true;
        } else {
            return false;
        }

    }

    private List<LinkedList<Integer>> buildGraph(int numCourses, int[][] prerequisites, int[] indegree) {
        List<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
            indegree[to]++;
        }

        return graph;
    }


}
