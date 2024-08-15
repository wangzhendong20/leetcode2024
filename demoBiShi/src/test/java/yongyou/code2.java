package yongyou;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = -1;
                if (arr[i][j] == 0) {
                    count = bfs(arr, i ,j);
                }
                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int bfs(int[][] arr ,int x, int y) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[x][y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                count++;
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr.length || visited[nextX][nextY]) {
                        continue;
                    }
                    if (arr[nextX][nextY] == 1) {
                        return count;
                    } else {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return -1;
    }
}
