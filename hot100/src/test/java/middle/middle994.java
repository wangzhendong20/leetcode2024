package middle;

import java.util.Deque;
import java.util.LinkedList;

public class middle994 {
    int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
    };
    /**
     * BFS
     * 每次遍历都是1周
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new LinkedList<>();
        int count = 0;
        int times = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        while (!deque.isEmpty() && count > 0) {
            int len = deque.size();
            times++;
            for (int j = 0; j < len; j++) {
                int[] cur = deque.poll();
                int curx = cur[0];
                int cury = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nextx = curx + dir[i][0];
                    int nexty = cury + dir[i][1];
                    if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                    if (grid[nextx][nexty] == 1) {
                        count--;
                        grid[nextx][nexty] = 2;
                        deque.offer(new int[]{nextx,nexty});
                    }
                }
            }

        }
        if (count > 0) {
            return -1;
        }
        return times;
    }
}
