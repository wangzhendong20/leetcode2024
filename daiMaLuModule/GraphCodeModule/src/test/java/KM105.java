import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KM105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[N+1];

        dfs(graph,1,visited);

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(1);
    }


    private static void dfs(List<LinkedList<Integer>> graph, int x, boolean[] visited) {
        if (visited[x]) return;
        visited[x] = true;

        for (Integer nx : graph.get(x)) {
            if (!visited[nx]) {
                dfs(graph, nx, visited);
            }
        }
    }
}
