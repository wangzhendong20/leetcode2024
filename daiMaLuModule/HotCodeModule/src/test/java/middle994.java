import java.util.Deque;
import java.util.LinkedList;

public class middle994 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        int count = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    deque.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    count++;
                }
            }
        }


        while (!deque.isEmpty() && count > 0) {
            int size = deque.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] curr = deque.poll();
                int curX = curr[0];
                int curY = curr[1];
                for (int[] dir : dirs) {
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
                    if (grid[newX][newY] == 1) {
                        count--;
                        grid[newX][newY] = 2;
                        deque.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        if (count > 0) {
            return -1;
        }

        return  ans;
    }

}
