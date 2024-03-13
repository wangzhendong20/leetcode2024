package simple;

public class simple1971 {
    int[] father;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        init();
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0],edges[i][1]);
        }
        return isSame(source,destination);
    }

    private void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    private int find(int u) {
        if (u == father[u]) return u;
        else return father[u] = find(father[u]);
    }

    private boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }
}
