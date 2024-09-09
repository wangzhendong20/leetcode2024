package xiaohongshu;

import java.util.Scanner;

public class code1 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] grid;
    static int[][] nums;
    static boolean[][] visited;
    static boolean[][] Cycle;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new char[n][m];
        nums = new int[n][m];
        visited = new boolean[n][m];
        Cycle = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]){
                    dfs(i,j);
                }
                if (nums[i][j] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(m*n - ans);

    }

    private static int dfs(int x, int y) {
        if (visited[x][y]) return nums[x][y];

        visited[x][y] = true;
        int nextX = x, nextY = y;

        switch(grid[x][y]){
            case 'L':
                nextY = y - 1;
                break;
            case 'R':
                nextY = y + 1;
                break;
            case 'U':
                nextX = x - 1;
                break;
            case 'D':
                nextX = x + 1;
                break;
        }

        if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
            nums[x][y] = 1;
        } else if (visited[nextX][nextY] && Cycle[nextX][nextY]) {
            nums[x][y] = 0;
        }else {
            nums[x][y] = dfs(nextX, nextY);
        }

        Cycle[x][y] = false;
        return nums[x][y];
    }


}
