package base;

public class UF {

    private int count;  // 连通分量个数
    public int[] father; // 父节点数组

    // 构造函数，初始化父节点数组
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
