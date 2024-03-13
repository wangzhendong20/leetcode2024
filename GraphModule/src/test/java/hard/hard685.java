package hard;

import java.util.ArrayList;
import java.util.List;

public class hard685 {
    int[] father = new int[1001];

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

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[1001];
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = edges.length-1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                list.add(i);  //记录当前入度为2的节点
            }
        }

        if (list.size() > 0) {
            if (isTreeAfterRemoveEdge(edges,list.get(0))) {
                return edges[list.get(0)];
            } else {
                return edges[list.get(1)];
            }
        }

        return getRemoveEdge(edges);
    }

    private boolean isTreeAfterRemoveEdge(int[][] edges, Integer deleteEdge) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) continue;
            if (isSame(edges[i][0],edges[i][1])) {
                return false;
            }else {
                join(edges[i][0],edges[i][1]);
            }
        }
        return true;
    }

    private int[] getRemoveEdge(int[][] edges) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return new int[]{};
    }
}
