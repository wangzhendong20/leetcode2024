import java.util.Deque;
import java.util.LinkedList;

public class middle994 {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Deque<int[]> deque = new LinkedList<>();
        int time = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        while(!deque.isEmpty() && count > 0) {
            int len = deque.size();
            time++;
            for(int i=0; i<len; i++) {
                int[] cur = deque.poll();
                int curx = cur[0];
                int cury = cur[1];
                for(int j=0; j<4; j++) {
                    int nx = curx + dir[j][0];
                    int ny = cury + dir[j][1];
                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;
                    if (grid[nx][ny] == 1) {
                        count--;
                        grid[nx][ny] = 2;
                        deque.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (count > 0) {
            return -1;
        }

        return time;
    }
}
