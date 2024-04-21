package base;

import java.util.Arrays;

public class Kruskal {

    public int minimumCost(int n, int[][] connections) {
        // 城市编号为 1...n，所以初始化大小为 n + 1
        UF uf = new UF(n + 1);
        // 对所有边按照权重从小到大排序
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        // 记录最小生成树的权重之和
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 若这条边会产生环，则不能加入 mst
            if (uf.isSame(u, v)) {
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            uf.join(u, v);
        }
        // 保证所有节点都被连通
        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return uf.count() == 2 ? mst : -1;
    }

    class UF {
        private int count;  // 连通分量个数
        private int[] father;

        public UF(int n) {
            this.count = n;
            father = new int[n];
            for (int i = 0; i < n; ++i) {
                father[i] = i;
            }
        }

        // 并查集里寻根的过程
        public int find(int u) {
            if (u == father[u]) return u;
                // 路径压缩
            else return father[u] = find(father[u]);
        }

        // 判断 u 和 v是否找到同一个根
        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        // 将v->u 这条边加入并查集
        public void join(int u, int v) {
            u = find(u); // 寻找u的根
            v = find(v); // 寻找v的根
            if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
            father[v] = u;
            count--;  // 两个连通分量合并成一个连通分量
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }
}
