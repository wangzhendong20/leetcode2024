package xiaohongshu;

import java.util.*;

public class MaxBlackNodesAfterRedRemoval {
    static int n;  // 节点的数量
    static List<Integer>[] graph;  // 邻接表表示的树
    static char[] colors;  // 存储每个节点的颜色
    static int[] blackCount;  // 存储每个子树中的黑色节点数量
    static int[] subtreeSize;  // 存储每个子树的大小
    static boolean[] visited;  // DFS标记访问状态
    static int totalBlackCount;  // 整棵树中的黑色节点总数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine(); // 处理换行符
        String colorStr = scanner.nextLine();
        colors = colorStr.toCharArray();  // 将颜色字符串转换为字符数组

        // 初始化图的邻接表
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 读取边的信息并构建图
        for (int i = 1; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 初始化黑色节点数量数组和子树大小数组
        blackCount = new int[n + 1];
        subtreeSize = new int[n + 1];
        visited = new boolean[n + 1];

        // 计算整棵树中的黑色节点数量
        totalBlackCount = 0;
        for (int i = 1; i <= n; i++) {
            if (colors[i - 1] == 'B') {
                totalBlackCount++;
            }
        }

        // 计算每个子树中的黑色节点数量和子树大小
        dfsCountBlackAndSize(1, -1);

        // 尝试删除每个红色节点，并计算最大黑色节点数量
        int maxBlackCount = 0;

        for (int i = 1; i <= n; i++) {
            if (colors[i - 1] == 'R') {  // 只处理红色节点
                int count1 = 0;
                for (int neighbor : graph[i]) {
                    if (subtreeSize[neighbor] > 0) {
                        count1 = Math.max(count1, blackCount[neighbor]);
                    }
                }
                int count2 = totalBlackCount - count1;  // 剩余的黑色节点数量
                maxBlackCount = Math.max(maxBlackCount, Math.max(count1, count2));
            }
        }

        System.out.println(maxBlackCount);
    }

    // 使用DFS计算每个子树中的黑色节点数量和子树大小
    private static void dfsCountBlackAndSize(int node, int parent) {
        int count = colors[node - 1] == 'B' ? 1 : 0;  // 当前节点是否是黑色
        subtreeSize[node] = 1;  // 初始化子树大小为1（当前节点）
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {  // 避免回到父节点
                dfsCountBlackAndSize(neighbor, node);
                count += blackCount[neighbor];  // 累加子树中的黑色节点数量
                subtreeSize[node] += subtreeSize[neighbor];  // 累加子树的大小
            }
        }
        blackCount[node] = count;  // 更新当前节点的黑色节点数量
    }
}
