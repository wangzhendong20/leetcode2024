import java.util.Arrays;
import java.util.Scanner;

public class KM53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] graph = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(graph[i], 10001);
        }
        for (int i = 0; i < E; i++) {
            int from  = sc.nextInt();
            int to   = sc.nextInt();
            int k = sc.nextInt();
            graph[from][to] = k;
            graph[to][from] = k;
        }

        //记录最小生成树
        int[] parent = new int[V+1];
        Arrays.fill(parent, -1);

        int[] minDist = new int[V+1];
        Arrays.fill(minDist,10001);
        boolean[] visited = new boolean[V+1];

        for (int i = 1; i < V; i++) {
            // 1、prim三部曲，第一步：选距离生成树最近节点
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            // 2、prim三部曲，第二步：最近节点（cur）加入生成树
            visited[cur] = true;

            // 3、prim三部曲，第三步：更新非生成树节点到生成树的距离（即更新minDist数组）
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && graph[cur][j] < minDist[j]) {
                    minDist[j] = graph[cur][j];

                    parent[j] = cur; // 记录最小生成树的边 （注意数组指向的顺序很重要）
                }
            }
        }

        int res = 0;
        for (int i = 2; i <= V; i++) {
            res += minDist[i];
        }

        // 输出 最小生成树边的链接情况
        for (int i = 1; i <= V; i++) {
            System.out.println(i + "->" + parent[i]);
        }

        System.out.println(res);
    }
}
