import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KM109 {

    private static int[] father;

    private static void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    private static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    private static int find(int u) {
        if (u == father[u]) return u;
        return father[u] = find(father[u]);
    }

    private static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[u] = v;
    }

    private static boolean isTreeAfterRemoveEdge(List<int[]> edges, int[] removeEdge) {
        // 初始化并查集
        init();
        // 判断是否连通
        for (int[] edge : edges) {
            if (edge[0] == removeEdge[0] && edge[1] == removeEdge[1]) continue;
            if (!isSame(edge[0], edge[1])) join(edge[0], edge[1]);
            else return false;
        }
        return true;
    }

    private static void getRemoveEdge(List<int[]> edges) {
        // 初始化并查集
        init();
        for (int[] edge : edges) {
            if (!isSame(edge[0], edge[1])) {
                // 有环就肯定是最后一条连上的边
                join(edge[0], edge[1]);
            } else {
                System.out.println(edge[0] + " " + edge[1]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //  记录每条边
        List<int[]> edges = new ArrayList<>();
        // 记录每个节点的入度
        int[] inDegree = new int[n + 1];
        father = new int[n + 1];
        while (n-- != 0) {
            int s = in.nextInt();
            int t = in.nextInt();
            inDegree[t]++;
            edges.add(new int[]{s, t});
        }
        // 存放入度为2的边
        LinkedList<int[]> twoDegreeEdge = new LinkedList<>();
        for (int[] edge : edges) {
            if (inDegree[edge[1]] == 2) twoDegreeEdge.addFirst(edge);
        }
        if (twoDegreeEdge.size() > 0) {
            // 存在入度为2的节点
            // 已经倒序，所以删除第一条边
            if (isTreeAfterRemoveEdge(edges, twoDegreeEdge.get(0))) {
                // 情况一
                System.out.println(twoDegreeEdge.get(0)[0] + " " + twoDegreeEdge.get(0)[1]);
            } else {
                // 情况二，只有一种选择，只能删除另外一条边
                System.out.println(twoDegreeEdge.get(1)[0] + " " + twoDegreeEdge.get(1)[1]);
            }
            return;
        }
        // 处理情况3
        getRemoveEdge(edges);
    }
}
