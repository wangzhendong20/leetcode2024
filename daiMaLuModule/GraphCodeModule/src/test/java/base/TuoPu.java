package base;

import java.util.*;

public class TuoPu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> map = new ArrayList<List<Integer>>(); //记录依赖关系
        int[] indegree = new int[n]; //记录每个节点的入度

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            map.get(from).add(to); // 记录指向哪些节点
            indegree[to]++; // to的入度加一
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { // 入度为0的文件，可以作为开头，先加入队列
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();// 当前选中的节点
            result.add(cur);
            for (Integer node : map.get(cur)) {
                indegree[node]--; // cur的指向的节点入度-1
                if (indegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if (i < result.size() - 1) {
                    System.out.println(" ");
                }
            }
        } else {
            System.out.println(-1);
        }

    }
}
