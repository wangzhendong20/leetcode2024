package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bellman_ford {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> grid = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            grid.add(new Edge(src, dest, weight));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        for (int i = 1; i < n; i++) { // 对所有边 松弛 n-1 次
            for (Edge edge : grid) { // 每一次松弛，都是对所有边进行松弛
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                // 松弛操作
                // minDist[from] != INT_MAX 防止从未计算过的节点出发
                if (minDist[src] != Integer.MAX_VALUE && minDist[dest] > minDist[src] + weight) {
                    minDist[dest] = minDist[src] + weight;
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[end]);
        }


    }
}
