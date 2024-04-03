package HuaWei.huawei0419;

import java.util.*;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int edge = in.nextInt();
            List<Integer>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < edge; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                graph[from].add(to);
            }
            HashSet<Integer> blockSet = new HashSet<>();
            int blockNum = in.nextInt();
            for (int i = 0; i < blockNum; i++) {
                int num = in.nextInt();
                blockSet.add(num);
            }

            dfs(graph,1,0,blockSet);
            if (resOut.toString().equals("")) {
                System.out.println("null");
            } else {
                System.out.println(resOut);
            }
            break;
        }
    }
    static StringBuilder resOut = new StringBuilder();
    static LinkedList<Integer> paths = new LinkedList<>();
    static int res = Integer.MAX_VALUE;

    /**
     * dfs
     * @param graph
     * @param len
     * @param index
     * @param blockSet
     */
    private static void dfs(List<Integer>[] graph, int len, int index,HashSet<Integer> blockSet) {
        if (blockSet.contains(index)) {
            return;
        }
        paths.add(index);
        if (graph[index].isEmpty()) {
            if (res > len) {
                res = len;
                resOut = new StringBuilder();
                for (int i = 0; i < paths.size(); i++) {
                    resOut.append(paths.get(i));
                    if (i != paths.size()-1){
                        resOut.append("->");
                    }
                }
            }
            return;
        }
        for (Integer i : graph[index]) {
            dfs(graph, len + 1, i, blockSet);
        }
        paths.removeLast();
    }

}
