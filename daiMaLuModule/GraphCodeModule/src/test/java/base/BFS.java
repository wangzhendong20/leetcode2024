package base;

import java.util.Deque;
import java.util.LinkedList;

public class BFS {

    // 表示四个方向
    int[][] dir = {
            {-1, 0},{1, 0},{0, -1},{0, 1}
    };


    private void bfs(int[][] graph, int x, int y, boolean[][] visited) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{x,y});
        visited[x][y] = true;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int[] d : dir) {
                int newX = curX + d[0];
                int newY = curY + d[1];
                if (newX < 0 || newX >= graph.length || newY < 0 || newY >= graph[0].length) continue;
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    deque.offer(new int[]{newX,newY});
                }
            }
        }

    }
}
