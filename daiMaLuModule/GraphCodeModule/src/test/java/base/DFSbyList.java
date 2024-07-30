package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DFSbyList {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    private static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        if (x == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i : graph.get(x)) {
            path.add(i);
            dfs(graph,i,n);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<LinkedList<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        path.add(1);
        dfs(graph,1,n);

        if (res.isEmpty()) System.out.println(-1);
        for (List<Integer> pa : res) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }
}

