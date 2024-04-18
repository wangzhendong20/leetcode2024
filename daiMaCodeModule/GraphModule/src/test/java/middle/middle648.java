package middle;

public class middle648 {
    int[] father;
    public int[] findRedundantConnection(int[][] edges) {
        father = new int[1001];
        init();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0],edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0],edges[i][1]);
            }
        }
        return edges[edges.length-1];
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

    private boolean isSame(int u, int v){
        u = find(u);
        v = find(v);
        return u == v;
    }

    private void join(int u ,int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }
}
