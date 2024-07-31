package base;

import java.util.*;

public class Kruskal {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n+1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (u == parent[u]) return u;
            else return parent[u] = find(parent[u]);
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            parent[v] = u;
        }

        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        int res_val = 0;
        List<Edge> result = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(src, dest, weight));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));// 按边的权值对边进行从小到大排序

        UF uf = new UF(V);
        // 从头开始遍历边
        for (Edge edge : edges) {
            // 并查集，搜出两个节点的祖先
            int x = uf.find(edge.src);
            int y = uf.find(edge.dest);

            if (x != y) {// 如果祖先不同，则不在同一个集合
                result.add(edge);
                res_val += edge.weight; // 这条边可以作为生成树的边
                uf.join(x,y); // 两个节点加入到同一个集合
            }
        }

        System.out.println(res_val);

        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }


    }

}
